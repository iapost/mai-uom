package com.example.ecar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecar.model.Car;
import com.example.ecar.model.Dealership;
import com.example.ecar.repository.CarRepository;
import com.example.ecar.repository.DealershipRepository;

@Service
public class DealershipService {

	@Autowired
	private CarRepository carRepo;

	@Autowired
	private DealershipRepository dealershipRepo;

	public Dealership getDealershipByToken(String token) {
		List<Dealership> dealerList = dealershipRepo.findByToken(token);
		if (dealerList.size() != 1) {
			throw new RuntimeException("Invalid token");
		}
		return dealerList.get(0);
	}

	public List<Car> getCars(String token) {
		Dealership d = getDealershipByToken(token);
		return d.getCars();
	}

	public void addCar(String token, String brand, String model, String fuel, int engine, int seats, double price,
			String info, int amount) {
		Dealership d = getDealershipByToken(token);
		Car newCar = new Car(brand, model, fuel, engine, seats, price, info, amount);
		newCar.setDealership(d);
		carRepo.save(newCar);
	}

	public void updateCar(String token, Car car) {
		Dealership d = getDealershipByToken(token);
		for (Car c : d.getCars()) {
			if (c.getId() == car.getId()) {
				c.setBrand(car.getBrand());
				c.setModel(car.getModel());
				c.setFuel(car.getFuel());
				c.setEngine(car.getEngine());
				c.setSeats(car.getSeats());
				c.setPrice(car.getPrice());
				c.setInfo(car.getInfo());
				c.setAmount(car.getAmount());
				carRepo.save(c);
				return;
			}
		}
		throw new RuntimeException("No car found with given id for this dealership");
	}

}
