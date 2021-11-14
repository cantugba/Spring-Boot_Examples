package com.sprinBootExamples.controller;

import com.sprinBootExamples.dto.Car;
import com.sprinBootExamples.exception.EntityNotFoundException;
import com.sprinBootExamples.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;


    @GetMapping
    public ResponseEntity<Car> getCar(@RequestParam String name) {
        return ResponseEntity.ok(carService.getCar(name));
    }
/**
    @ExceptionHandler({EntityNotFoundException.class})
    public String entityNotFound() {
        return "Record not found";
    }
    **/
}