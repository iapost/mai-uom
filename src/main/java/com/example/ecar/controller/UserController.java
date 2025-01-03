package com.example.ecar.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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

	//proigoumeni methodos login pou douleue. 
	// localhost:8080/login
	@PostMapping(path = "/login")
	public Credentials login(@RequestBody Credentials attemtedCreds) throws Exception {
		Credentials verifiedCreds = userService.login(attemtedCreds);
		return verifiedCreds;
	}

//	//ksekinisa na to kano me session gia na kratame to id tou client/dealership gia oles tis energeies (prosthiki, agora, testdrive)
//	//mallon douleuei, thelei allagi to frontend gia na ypodexetai sosta to response
//	@PostMapping(path = "/login")
//	public ResponseEntity<String> login(@RequestBody Credentials attemtedCreds, HttpSession session) throws Exception {
//		Credentials verifiedCreds = userService.login(attemtedCreds);
//		if (verifiedCreds != null) {
//			int userId = userService.getUserId(verifiedCreds.getId());
//			session.setAttribute("userId", userId);
//			if (verifiedCreds.getRole() == 1)
//				session.setAttribute("role", 1);
//			else
//				session.setAttribute("role", 2);
//
//			return ResponseEntity.ok("Login successfull");
//		}
//		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
//
//	}
//
//	//auto gia na tsekarei an yparxei o user gia na syndethei. edo stamatisa prin se steilo
//	@GetMapping(path = "/userId")
//	public ResponseEntity<Integer> getUserId(HttpSession session){
//		int userId = (int) session.getAttribute("userId");
//		if(userId != null) {
//			return ResponseEntity.ok(userId);
//		}
//		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();			
//		}
	

	// localhost:8080/clientRegister
	@PostMapping(path = "/clientRegister")
	public void clientRegister(@RequestBody Map<String, Object> requestBody) {
		userService.clientRegister(requestBody);
	}

	// localhost:8080/dealerRegister
	@PostMapping(path = "/dealershipRegister")
	public void dealershipRegister(@RequestBody Map<String, Object> requestBody) {
		userService.dealershipRegister(requestBody);
	}

}
