package com.example.ecar.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecar.model.Client;
import com.example.ecar.model.Dealership;
import com.example.ecar.repository.ClientRepository;
import com.example.ecar.repository.DealershipRepository;

@Service
public class UserService {

	@Autowired
	private ClientRepository clientRepo;

	@Autowired
	private DealershipRepository dealershipRepo;

	public String login(int afm, String password) {
		String token = UUID.randomUUID().toString();
		Optional<Client> optClient = clientRepo.findById(afm);
		if (optClient.isPresent()) {
			Client c = optClient.get();
			if (!c.getPassword().equals(password)) {
				throw new RuntimeException("Invalid Credentials");
			}
			c.setToken(token);
			clientRepo.save(c);
		} else {
			Optional<Dealership> optDealership = dealershipRepo.findById(afm);
			if (optClient.isEmpty()) {
				throw new RuntimeException("Invalid Credentials");
			}
			Dealership d = optDealership.get();
			if (!d.getPassword().equals(password)) {
				throw new RuntimeException("Invalid Credentials");
			}
			d.setToken(token);
			dealershipRepo.save(d);
		}
		return token;
	}

	public void clientRegister(int afm, String password, String firstName, String lastName, String email) {
		if (clientRepo.existsById(afm) || dealershipRepo.existsById(afm)) {
			throw new RuntimeException("Account with this afm already exists");
		}
		clientRepo.save(new Client(afm, password, firstName, lastName, email));
	}

	public void dealershipRegister(int afm, String password, String name, String owner) {
		if (clientRepo.existsById(afm) || dealershipRepo.existsById(afm)) {
			throw new RuntimeException("Account with this afm already exists");
		}
		dealershipRepo.save(new Dealership(afm, password, name, owner));
	}

	public Client getClientByToken(String token) {
		List<Client> clientList = clientRepo.findByToken(token);
		if (clientList.size() != 1) {
			throw new RuntimeException("Invalid token");
		}
		return clientList.get(0);
	}
	
	public Dealership getDealershipByToken(String token) {
		List<Dealership> dealerList = dealershipRepo.findByToken(token);
		if (dealerList.size() != 1) {
			throw new RuntimeException("Invalid token");
		}
		return dealerList.get(0);
	}

}
