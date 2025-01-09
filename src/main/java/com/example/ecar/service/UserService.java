package com.example.ecar.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecar.dto.LoginResponseDto;
import com.example.ecar.exception.AlreadyExistsException;
import com.example.ecar.exception.AuthFailureException;
import com.example.ecar.model.AuthenticatedUser;
import com.example.ecar.model.Client;
import com.example.ecar.model.Dealership;
import com.example.ecar.repository.AuthenticatedUserRepository;
import com.example.ecar.repository.ClientRepository;
import com.example.ecar.repository.DealershipRepository;

@Service
public class UserService {

	@Autowired
	private ClientRepository clientRepo;
	
	@Autowired
	private AuthenticatedUserRepository authUserRepo;

	@Autowired
	private DealershipRepository dealershipRepo;

	public LoginResponseDto login(int afm, String password) {
		LoginResponseDto result = new LoginResponseDto();
		AuthenticatedUser user = authUserRepo.findByAfmAndPassword(afm, password).orElseThrow(AuthFailureException::new);
		
		result.token = UUID.randomUUID().toString();
		result.role = user.getRole();
		
		user.setToken(result.token);
		authUserRepo.save(user);
		
		return result;
	}

	public void clientRegister(int afm, String password, String firstName, String lastName, String email) {
		if (authUserRepo.existsById(afm)) {
			throw new AlreadyExistsException();
		}
		clientRepo.save(new Client(afm, password, firstName, lastName, email));
	}

	public void dealershipRegister(int afm, String password, String name, String owner) {
		if (authUserRepo.existsById(afm)) {
			throw new AlreadyExistsException();
		}
		dealershipRepo.save(new Dealership(afm, password, name, owner));
	}

}
