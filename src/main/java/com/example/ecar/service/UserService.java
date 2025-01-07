package com.example.ecar.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecar.dto.LoginResponseDto;
import com.example.ecar.exception.AlreadyExistsException;
import com.example.ecar.exception.AuthFailureException;
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

	public LoginResponseDto login(int afm, String password) {
		LoginResponseDto result = new LoginResponseDto();
		result.token = UUID.randomUUID().toString();
		Optional<Client> optClient = clientRepo.findById(afm);
		if (optClient.isPresent()) {
			Client c = optClient.get();
			if (!c.getPassword().equals(password)) {
				throw new AuthFailureException();
			}
			c.setToken(result.token);
			clientRepo.save(c);
			result.role = 1;
		} else {
			Optional<Dealership> optDealership = dealershipRepo.findById(afm);
			if (optDealership.isEmpty()) {
				throw new AuthFailureException();
			}
			Dealership d = optDealership.get();
			if (!d.getPassword().equals(password)) {
				throw new AuthFailureException();
			}
			d.setToken(result.token);
			dealershipRepo.save(d);
			result.role = 2;
		}
		return result;
	}

	public void clientRegister(int afm, String password, String firstName, String lastName, String email) {
		if (clientRepo.existsById(afm) || dealershipRepo.existsById(afm)) {
			throw new AlreadyExistsException();
		}
		clientRepo.save(new Client(afm, password, firstName, lastName, email));
	}

	public void dealershipRegister(int afm, String password, String name, String owner) {
		if (clientRepo.existsById(afm) || dealershipRepo.existsById(afm)) {
			throw new AlreadyExistsException();
		}
		dealershipRepo.save(new Dealership(afm, password, name, owner));
	}

}
