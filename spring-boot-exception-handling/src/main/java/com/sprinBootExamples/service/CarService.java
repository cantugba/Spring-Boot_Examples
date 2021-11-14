package com.sprinBootExamples.service;

import com.sprinBootExamples.dto.Car;
import com.sprinBootExamples.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    private static List<Car> carList = new ArrayList<>();

    @PostConstruct
    public void init() {
        carList.add(new Car("Car A", "Brand 1"));
        carList.add(new Car("Car B", "Brand 2"));
        carList.add(new Car("Car C", "Brand 3"));
    }

    public Car getCar(String name) {
        if (name.startsWith("^[0-9]")){
            throw new IllegalArgumentException();
        }
       return carList.stream().filter(item -> item.getName().equals(name)).findFirst()
               .orElseThrow(() -> new EntityNotFoundException(name));
    }
}