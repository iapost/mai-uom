package com.example.ecar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecar.model.Car;
import com.example.ecar.model.Client;
import com.example.ecar.repository.CarRepository;
import com.example.ecar.repository.ClientRepository;
import com.example.ecar.repository.DealershipRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepo;

	@Autowired
	private CarRepository carRepo;

	@Autowired
	private DealershipRepository dealerRepo;

	public List<Car> getCars() throws Exception {
		return carRepo.findAll();
	}
	
	public Client getClientByToken(String token) {
		List<Client> clientList = clientRepo.findByToken(token);
		if (clientList.size() != 1) {
			throw new RuntimeException("Invalid token");
		}
		return clientList.get(0);
	}
	
	public List<Car> searchCars(String brand, String model, String fuel, Integer seats, Double fromPrice, Double toPrice, Integer fromEngine, Integer toEngine) {
		return carRepo.search(brand, model, fuel, seats, fromPrice, toPrice, fromEngine, toEngine);
	}

	// edo skeftika oti kalo tha itan na yparxei pinakas boughtCars pou na ton
	// ftiaxnoume emeis ws entity opos kai ta ypoloipa, gia na to xeiristoume
	// paromoia me to save ktl
	// TODO
	public void buyCar(Car car) throws Exception {
		// Optional<Car> byId = carRepo.findById(car.getId());
		Car boughtCar = carRepo.findById(car.getId()).orElseThrow(() -> new RuntimeException("Car not found"));
		boughtCar.setAmount(boughtCar.getAmount() - 1);

	}

	// gia tin dimiourgia object client apo to configuration
	public void addClient(Client c) throws Exception {
		Optional<Client> byId = clientRepo.findById(c.getAfm());
		if (!byId.isPresent())
			clientRepo.save(c);
	}

}
