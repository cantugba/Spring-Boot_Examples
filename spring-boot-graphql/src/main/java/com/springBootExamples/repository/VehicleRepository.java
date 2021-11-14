package com.springBootExamples.repository;

import java.util.List;

import com.springBootExamples.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository  extends JpaRepository<Vehicle, Long> {
    List<Vehicle> getByTypeLike(String type);
 }