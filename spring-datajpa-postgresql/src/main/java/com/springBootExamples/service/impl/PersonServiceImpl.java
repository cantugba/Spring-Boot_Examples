package com.springBootExamples.service.impl;

import com.springBootExamples.dto.PersonDto;
import com.springBootExamples.entity.Address;
import com.springBootExamples.entity.Person;
import com.springBootExamples.repository.AddressRepository;
import com.springBootExamples.repository.PersonRepository;
import com.springBootExamples.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;

    @Override
    @Transactional
    public PersonDto save(PersonDto personDto) {
        Assert.isNull(personDto.getName(), "name field is required");

        Person person = new Person();
        person.setName(personDto.getName());
        person.setSurname(personDto.getSurname());
        final Person personDb = personRepository.save(person);
        List<Address> list= new ArrayList<>();
        personDto.getAdresses().forEach(item -> {
            Address address = new Address();
            address.setAddress(item);
            address.setAddressType(Address.AddressType.OTHER);
            address.setIsActive(true);
            address.setPerson(personDb);
            list.add(address);
        });
        addressRepository.saveAll(list);
        personDto.setId(personDb.getId());
        return personDto;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public List<PersonDto> getAll() {
        List<Person> personList = personRepository.findAll();
        List<PersonDto> personDtos = new ArrayList<>();
        personList.forEach(item -> {
            PersonDto personDto = new PersonDto();
            personDto.setId(item.getId());
            personDto.setName(item.getName());
            personDto.setSurname(item.getSurname());
            personDto.setAdresses(item.getAdresses().stream().map(Address::getAddress)
                    .collect(Collectors.toList()));
            personDtos.add(personDto);

        });
        return personDtos;
    }

    @Override
    public Page<PersonDto> getAll(Pageable pageable) {
        return null;
    }
}
