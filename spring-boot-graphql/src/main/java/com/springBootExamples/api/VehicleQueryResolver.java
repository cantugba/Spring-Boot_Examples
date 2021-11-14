package com.springBootExamples.api;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.springBootExamples.entity.Vehicle;
import com.springBootExamples.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

// kayıt sorgulama, get

@Component
@RequiredArgsConstructor
public class VehicleQueryResolver implements GraphQLResolver {
    @Autowired
    private final VehicleRepository vehicleRepository;

    public List<Vehicle> getVehicle(String type) {
       return vehicleRepository.getByTypeLike(type);
    }

    public Optional<Vehicle> getById(Long id) {
        return vehicleRepository.findById(id);
    }

}
