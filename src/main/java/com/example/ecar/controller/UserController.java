package com.example.ecar.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecar.model.Credentials;
import com.example.ecar.service.UserService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	// localhost:8080/login
	@PostMapping(path = "/login")
	public Credentials login(@RequestBody Credentials attemtedCreds) throws Exception {
		Credentials verifiedCreds = userService.login(attemtedCreds);
		return verifiedCreds;
	}

	// localhost:8080/clientRegister
	@PostMapping(path = "/clientRegister")
	public void clientRegister(@RequestBody Map<String, Object> requestBody) {
		userService.clientRegister(requestBody);
	}

	// localhost:8080/dealerRegister
	@PostMapping(path = "/dealerRegister")
	public void dealerRegister(@RequestBody Map<String, Object> requestBody) {
		userService.dealershipRegister(requestBody);
	}

}
