package com.example.ecar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecar.dto.ClientRegisterRequestDto;
import com.example.ecar.dto.DealershipRegisterRequestDto;
import com.example.ecar.dto.LoginRequestDto;
import com.example.ecar.service.UserService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(path = "/login")
	public String login(@RequestBody LoginRequestDto loginRequestDto) {
		return userService.login(loginRequestDto.afm, loginRequestDto.password);
	}

	@PostMapping(path = "/clientRegister")
	public void clientRegister(@RequestBody ClientRegisterRequestDto dto) {
		userService.clientRegister(dto.afm, dto.password, dto.firstName, dto.lastName, dto.email);
	}

	@PostMapping(path = "/dealershipRegister")
	public void dealershipRegister(@RequestBody DealershipRegisterRequestDto dto) {
		userService.dealershipRegister(dto.afm, dto.password, dto.name, dto.owner);
	}

}
