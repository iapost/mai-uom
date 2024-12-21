package com.example.ecar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecar.model.Credentials;
import com.example.ecar.repos.ClientRepository;
import com.example.ecar.repos.CredentialsRepository;
import com.example.ecar.repos.DealershipRepository;

@Service
public class UserService {

	@Autowired
	private CredentialsRepository credsRepo;
	
	@Autowired
	private ClientRepository clientRepo;
	
	@Autowired
	private DealershipRepository dealershipRepo;

	// sygkrinoume ta creds poy irthan me tin klisi tis mehtodou me ola ta creds pou
	// yparxoun stin vasi. Se periptosi pou vrethei omoiotita epistrefetai olo to
	// antikeimeno gia na eksetasei to front end ton rolo
	// kai analoga na kanei redirect.
	// Se periptosi pou einai lathos ta creds...
	public Credentials login(Credentials attemtedCreds) throws Exception {

		List<Credentials> allCreds = credsRepo.findAll();
		Credentials verifiedCreds = new Credentials("no", "no", 0);
		for (Credentials c : allCreds) {
			if (c.getUsername().equals(attemtedCreds.getUsername())
					&& c.getPassword().equals(attemtedCreds.getPassword())) {
				verifiedCreds = c;
				break;
			}
		}

		return verifiedCreds;
	}

}
