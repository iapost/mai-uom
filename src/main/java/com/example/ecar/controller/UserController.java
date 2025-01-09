package com.example.ecar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecar.dto.ClientRegisterRequestDto;
import com.example.ecar.dto.DealershipRegisterRequestDto;
import com.example.ecar.dto.LoginRequestDto;
import com.example.ecar.dto.LoginResponseDto;
import com.example.ecar.service.UserService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public LoginResponseDto login(@RequestBody LoginRequestDto dto) {
		return userService.login(dto.afm, dto.password);
	}
	
	@GetMapping("/logout")
	public void logout(@RequestParam String token) {
		userService.logout(token);
	}

	@PostMapping("/clientRegister")
	public void clientRegister(@RequestBody ClientRegisterRequestDto dto) {
		userService.clientRegister(dto.afm, dto.password, dto.firstName, dto.lastName, dto.email);
	}

	@PostMapping("/dealershipRegister")
	public void dealershipRegister(@RequestBody DealershipRegisterRequestDto dto) {
		userService.dealershipRegister(dto.afm, dto.password, dto.name, dto.owner);
	}

}
