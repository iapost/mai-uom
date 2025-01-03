package com.example.ecar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecar.model.Car;
import com.example.ecar.model.Client;
import com.example.ecar.repos.CarRepository;
import com.example.ecar.repos.ClientRepository;
import com.example.ecar.repos.DealershipRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepo;

	@Autowired
	private CarRepository carRepo;

	@Autowired
	private DealershipRepository dealerRepo;

	public void addClient(Client c) throws Exception {
		Optional<Client> byId = clientRepo.findById(c.getId());
		if (!byId.isPresent())
			clientRepo.save(c);
	}
	
	public List<Car> getCars() throws Exception {
		return carRepo.findAll();
	}
	
	
	public void buyCar(Car car) throws Exception {
		//Optional<Car> byId = carRepo.findById(car.getId());
		Car boughtCar = carRepo.findById(car.getId()).orElseThrow(() -> new RuntimeException("Car not found"));
		boughtCar.setAmount(boughtCar.getAmount() - 1);
		
		
	}

	
	public List<Car> searchCars(String brand, String model, String fuel, String priceStr) {
		
		double price = Double.parseDouble(priceStr);
		
		System.out.println("Here it is:[" + brand + "]");
		System.out.println("Here it is:[" + model + "]");
		System.out.println("Here it is:[" + fuel + "]");
		System.out.println("Here it is:[" + priceStr + "]");
		List<Car> allCars = carRepo.findAll();
		List<Car> searchResultCars = new ArrayList<Car>();
		
		for(Car c : allCars) {
			if(c.getBrand().equals(brand)) {
				searchResultCars.add(c);
			}
		}
		
		return searchResultCars;
		
	}
	

}
