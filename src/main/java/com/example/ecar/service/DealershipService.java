package com.example.ecar.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecar.model.Car;
import com.example.ecar.repos.CarRepository;
import com.example.ecar.repos.DealershipRepository;

@Service
public class DealershipService {
	
	@Autowired
	private CarRepository carRepo;
	@Autowired
	private DealershipRepository dealerRepo;
	
	
	//thelei na krataei kai to id tou dealer gia na prostethei kai stin lista tou, oxi mono sto repo tou car
	public void addCar(Car car) throws Exception {
		Optional<Car> byId = carRepo.findById(car.getId());
		if(!byId.isPresent())
			carRepo.save(car);
	}
	
	//den ksero an autow o tropow einai sostos
	public Car viewCar(Car car) throws Exception{
		return car;
	}

}
