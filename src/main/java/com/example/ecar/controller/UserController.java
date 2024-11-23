package com.example.ecar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecar.service.UserService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserController {

	@Autowired
	public UserService service;

	@GetMapping(path = "/login")
	public void login(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password) throws Exception {

		service.login(username, password);

	}

	@GetMapping(path = "/registerDealer")
	public void registerDealer(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password) {

	}

	@GetMapping(path = "/clientRegister")
	public void clientRegister(@RequestParam(value = "name") String name,
			@RequestParam(value = "surname") String surname, @RequestParam(value = "afm") String afm,
			@RequestParam(value = "email") String email, @RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password) throws Exception {

		int role = 1;
		int creds_id = service.credentialRegister(username, password, role);
		
		service.clientRegister(name, surname, afm, email, creds_id);

	}

}
