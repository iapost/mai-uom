package com.example.ecar.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecar.model.Client;
import com.example.ecar.model.Credentials;
import com.example.ecar.model.CredentialsRepository;
import com.example.ecar.model.Dealership;

@Service
public class UserService {

	@Autowired
	private CredentialsRepository credsRepo;

	public void credentialRegister(Credentials creds) throws Exception {

		Optional<Credentials> byId = credsRepo.findById(creds.getId());
		System.out.println("gothere");
		if (!byId.isPresent())
			credsRepo.save(creds);

	}

	public void clientCreation(Client client) throws Exception {

	}

	public void dealershipCreation(Dealership dealer) throws Exception {

	}

	public void login(Credentials creds) throws Exception {

		Optional<Credentials> byId = credsRepo.findById(creds.getId());
		System.out.println("got to login");
		if (!byId.isPresent())
			credsRepo.save(creds);

	}

}
