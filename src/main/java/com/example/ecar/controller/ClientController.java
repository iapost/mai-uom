package com.example.ecar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecar.model.Car;
import com.example.ecar.service.ClientService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/client")
@RestController
public class ClientController {

	@Autowired
	private ClientService cService;

	@GetMapping(path = "/search")
	public List<Car> searchCars(@RequestParam(value = "brand") String brand,
			@RequestParam(value = "model") String model, @RequestParam(value = "fuel") String fuel,
			@RequestParam(value = "price") String price) throws Exception {

		return cService.searchCars(brand, model, fuel, price);

	}

	// localhost:8080/client/getCars
	@GetMapping(path = "/getCars")
	public List<Car> getCars() throws Exception {
		return cService.getCars();
	}

	// localhost:8080/client/buyCar
	@PostMapping(path = "/buyCar")
	public void addCar(@RequestBody Car car) throws Exception {
		cService.buyCar(car);
	}

}
