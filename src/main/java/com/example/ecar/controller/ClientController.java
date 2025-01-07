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

import com.example.ecar.dto.SearchCarRequestDto;
import com.example.ecar.model.Car;
import com.example.ecar.service.ClientService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/client")
@RestController
public class ClientController {

	@Autowired
	private ClientService clientService;

	@PostMapping("/search")
	public List<Car> searchCars(@RequestBody SearchCarRequestDto dto) throws Exception {
		System.out.println((dto.brand==null));
		return clientService.searchCars(dto.brand, dto.model, dto.fuel, dto.seats, dto.fromPrice, dto.toPrice, dto.fromEngine, dto.toEngine);
	}

	@GetMapping("/getCars")
	public List<Car> getCars() throws Exception {
		return clientService.getCars();
	}

	// localhost:8080/client/buyCar
	@PostMapping("/buyCar")
	public void addCar(@RequestBody Car car) throws Exception {
		clientService.buyCar(car);
	}

}
