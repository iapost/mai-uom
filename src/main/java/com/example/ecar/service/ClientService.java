package com.example.ecar.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecar.model.Car;
import com.example.ecar.model.Client;
import com.example.ecar.model.Dealership;
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

}
