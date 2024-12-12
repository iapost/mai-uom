package com.example.ecar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecar.model.Client;
import com.example.ecar.model.Credentials;
import com.example.ecar.model.Dealership;
import com.example.ecar.service.UserService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserController {

	@Autowired
	public UserService userService;

	@PostMapping(path = "/login")
	public void login(@RequestBody Credentials creds) throws Exception {

		userService.login(creds);

	}

	@PostMapping(path = "/clientRegister")
	public void clientRegister(@RequestBody Credentials creds) throws Exception {

		userService.credentialRegister(creds);

	}

	@PostMapping(path = "/clientCreation")
	public void clientCreation(@RequestBody Client client) throws Exception {

		userService.clientCreation(client);

	}

	@PostMapping(path = "/dealershipRegister")
	public void dealershipRegister(@RequestBody Credentials creds) throws Exception {

		userService.credentialRegister(creds);

	}

	@PostMapping(path = "/dealershipCreation")
	public void dealershipCreation(@RequestBody Dealership dealer) throws Exception {

		userService.dealershipCreation(dealer);

	}

}
