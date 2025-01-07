package com.example.ecar.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.ecar.model.Client;
import com.example.ecar.service.ClientService;

@Configuration
public class ClientServiceConfiguration implements CommandLineRunner {

	@Autowired
	private ClientService cService;

	@Override
	public void run(String... args) throws Exception {

		Client c1 = new Client(123456789, "123", "Τάσος", "Χρυσοχοΐδης", "mai25067@uom.edu.gr");
		Client c2 = new Client(987654321, "123", "Γιάννης", "Αποστολάκης", "mai25004@uom.edu.gr");

		cService.addClient(c1);
		cService.addClient(c2);

	}

}
