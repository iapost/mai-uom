package com.example.ecar.controller;

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
	


}
