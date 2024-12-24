package com.example.ecar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.ecar.model.Car;
import com.example.ecar.model.Client;
import com.example.ecar.model.Credentials;
import com.example.ecar.model.Dealership;

@Configuration
public class ClientServiceConfiguration implements CommandLineRunner {

	@Autowired
	private ClientService cService;

	@Override
	public void run(String... args) throws Exception {

		Client c1 = new Client(123456789, "Τάσος", "Χρυσοχοΐδης", "mai25067@uom.edu.gr");
		Client c2 = new Client(987654321, "Γιάννης", "Αποστολάκης", "mai25004@uom.edu.gr");

		Credentials creds1 = new Credentials("tasos", "123", 1);
		Credentials creds2 = new Credentials("giannis", "123", 1);

		c1.setCreds(creds1);
		c2.setCreds(creds2);

		cService.addClient(c1);
		cService.addClient(c2);

	}

}
