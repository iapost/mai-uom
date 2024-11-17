package com.example.ecar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecar.model.CarDealership;
import com.example.ecar.service.InitService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ClientController {

	@Autowired
	private InitService service;

	// http://localhost:8080/addCar?brand={brand}&model={model}&...
	@GetMapping(path = "/addCar")
	public void addCar(@RequestParam(value = "brand") String brand, @RequestParam(value = "model") String model,
			@RequestParam(value = "fuel") String fuel, @RequestParam(value = "engine") String engine,
			@RequestParam(value = "seats") int seats, @RequestParam(value = "price") double price,
			@RequestParam(value = "info") String info, @RequestParam(value = "amount") int amount,
			@RequestParam(value = "carDealership") CarDealership carDealership) {

		service.addCar(brand, model, fuel, engine, seats, price, info, amount, carDealership);

	}
	
	// http://localhost:8080/viewCars?dealership={dealershipID}
	@GetMapping(path= "/viewCars")
	public void  viewCars(@RequestParam(value="dealership") int id) {
		
	}

}
