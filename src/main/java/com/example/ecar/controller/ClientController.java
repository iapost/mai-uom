package com.example.ecar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecar.model.Dealership;
import com.example.ecar.service.ClientService;
import com.example.ecar.service.DealershipService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ClientController {

	@Autowired
	private ClientService service;

	
	


}
