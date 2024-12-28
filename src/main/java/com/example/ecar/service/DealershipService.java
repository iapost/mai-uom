package com.example.ecar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.ecar.model.Car;
import com.example.ecar.model.Dealership;
import com.example.ecar.repos.CarRepository;
import com.example.ecar.repos.DealershipRepository;

@Service
public class DealershipService {
	
	@Autowired
	private CarRepository carRepo;
	@Autowired
	private DealershipRepository dealerRepo;

	
	
	public List<Car> getCars() throws Exception {
		return carRepo.findAll();
	}
	

	//thelei na krataei kai to id tou dealer gia na prostethei kai stin lista tou, oxi mono sto repo tou car
	public void addCar(Car car) throws Exception {
		Optional<Car> byId = carRepo.findById(car.getId());
		if(!byId.isPresent())
			carRepo.save(car);
	}
	
	
	//pairnoyme ena anatheorimeno car kai epeidi sto request exoume kai to id, tote me to aplo save katalavainei kai kanei update
		public Car updateCar(Car updatedCar){
			return carRepo.save(updatedCar);
			
		}
		
		public void addDealership(Dealership dealership) throws Exception{
			Optional<Dealership> byId = dealerRepo.findById(dealership.getId());
			if(!byId.isPresent())
				dealerRepo.save(dealership);
		}
		



}
