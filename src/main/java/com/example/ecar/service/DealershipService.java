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

	// OK
	// epistefei ola ta carss tis vasis.
	// TODO Tha prepei na epistrefei mono ta dika tou cars kai auto tha lythei me to
	// session, exontas kratimeno to id tou dealsership
	public List<Car> getCars() throws Exception {
		return carRepo.findAll();
	}

	// OK
	// prosthetei car stin vasi.
	// TODO Kai auto tha prepei na prosthetei car me to id tou loggarismenou
	// dealership. Tha lythei me to session
	public void addCar(Car car) throws Exception {
		Optional<Car> byId = carRepo.findById(car.getId());
		if (!byId.isPresent())
			carRepo.save(car);
	}

	// OK
	// pairnoyme ena anatheorimeno car kai epeidi sto request exoume kai to car.id,
	// tote me to aplo save katalavainei kai kanei update
	public Car updateCar(Car updatedCar) {
		return carRepo.save(updatedCar);

	}

	// gia tin dimiourgia object dealership apo to configuration
	public void addDealership(Dealership dealership) throws Exception {
		Optional<Dealership> byId = dealerRepo.findById(dealership.getId());
		if (!byId.isPresent())
			dealerRepo.save(dealership);
	}

}
