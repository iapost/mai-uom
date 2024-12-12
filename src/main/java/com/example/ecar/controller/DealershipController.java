package com.example.ecar.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecar.model.Car;
import com.example.ecar.model.Dealership;
import com.example.ecar.service.DealershipService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class DealershipController {

	@Autowired
	public DealershipService dealershipService;

	// http://localhost:8080/addCar?brand={brand}&model={model}&...
	@GetMapping(path = "/addCar")
	public void addCar(@RequestParam(value = "brand") String brand, @RequestParam(value = "model") String model,
			@RequestParam(value = "fuel") String fuel, @RequestParam(value = "engine") String engine,
			@RequestParam(value = "seats") int seats, @RequestParam(value = "price") double price,
			@RequestParam(value = "info") String info, @RequestParam(value = "amount") int amount,
			@RequestParam(value = "carDealership") Dealership carDealership) {

		dealershipService.addCar(brand, model, fuel, engine, seats, price, info, amount, carDealership);

	}

	// http://localhost:8080/viewCars?dealership={dealershipID}
	@GetMapping(path = "/viewCars")
	public ArrayList<Car> viewCars(@RequestParam(value = "dealership") int id) throws Exception {
		return dealershipService.viewCars(id);

	}
}
