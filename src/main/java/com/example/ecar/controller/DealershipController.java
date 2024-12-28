package com.example.ecar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecar.model.Car;
import com.example.ecar.service.DealershipService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/dealership")
@RestController
public class DealershipController {

	@Autowired
	private DealershipService dService;

	// localhost:8080/dealership/getCars
	@GetMapping(path = "/getCars")
	public List<Car> getCars() throws Exception {
		return dService.getCars();
	}

	// localhost:8080/dealership/addCar
	@PostMapping(path = "/addCar")
	public void addCar(@RequestBody Car car) throws Exception {
		dService.addCar(car);
	}

	// localhost:8080/dealership/updateCar
	@PutMapping("/updateCar")
	public Car updateCar(@RequestBody Car car) {
		return dService.updateCar(car);
	}

}
