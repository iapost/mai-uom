package com.example.ecar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecar.model.Car;

public interface CarRepository extends JpaRepository<Car, Integer> {

}
