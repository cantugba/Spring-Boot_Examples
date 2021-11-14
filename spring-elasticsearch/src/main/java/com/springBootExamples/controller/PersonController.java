package com.springBootExamples.controller;

import com.springBootExamples.entity.Person;
import com.springBootExamples.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonRepository personRepository;

    /*
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    } */

    @PostConstruct
    public void init() {
        Person person = new Person();
        person.setName("Feanor");
        person.setSurname("Noldor");
        person.setAddress("Gondolin, Middle Earth");
        person.setBirthday(Calendar.getInstance().getTime());
        person.setId("k001");
        personRepository.save(person);
    }

    @GetMapping("/{search}")
    public ResponseEntity<List<Person>> getPerson(@PathVariable String search) {
        // elastic search query
       //List<Person> people = personRepository.getByCustomQuery(search);

        //spring boot
        List<Person> people = personRepository.findByNameLikeOrSurnameLike(search, search);
        return ResponseEntity.ok(people);
    }



}
