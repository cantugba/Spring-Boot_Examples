package com.springBootExamples.api;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.springBootExamples.dto.VehicleDto;
import com.springBootExamples.entity.Vehicle;
import com.springBootExamples.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

// save update gibi işlemler

@Component
@RequiredArgsConstructor
public class VehicleMutationResolver implements GraphQLMutationResolver {

    private final VehicleRepository vehicleRepository;

    public Vehicle createVehicle(VehicleDto vehicleDto) {
        return vehicleRepository.save(dtoToEntity(vehicleDto));
    }

    private Vehicle dtoToEntity(VehicleDto vehicleDto) {
        Vehicle vehicle = new Vehicle();
        vehicle.setBrandName(vehicleDto.getBrandName());
        vehicle.setModelCode(vehicleDto.getModelCode());
        vehicle.setLaunchDate(new Date());
        vehicle.setType(vehicleDto.getType());

        return vehicle;
    }
}
