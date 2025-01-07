package com.example.ecar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecar.exception.AuthFailureException;
import com.example.ecar.exception.BadRequestException;
import com.example.ecar.model.Car;
import com.example.ecar.model.Client;
import com.example.ecar.repository.CarRepository;
import com.example.ecar.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepo;

	@Autowired
	private CarRepository carRepo;

	public List<Car> getCars() {
		return carRepo.findAll();
	}
	
	public Client getClientByToken(String token) {
		List<Client> clientList = clientRepo.findByToken(token);
		if (clientList.size() != 1) {
			throw new AuthFailureException();
		}
		return clientList.get(0);
	}
	
	public List<Car> searchCars(String brand, String model, String fuel, Integer seats, Double fromPrice, Double toPrice, Integer fromEngine, Integer toEngine) {
		return carRepo.search(brand, model, fuel, seats, fromPrice, toPrice, fromEngine, toEngine);
	}

	public void buyCar(String token, int id) {
		getClientByToken(token);
		if (carRepo.buyCar(id) != 1) {
			throw new BadRequestException("Could not complete transaction");
		}
	}

}
