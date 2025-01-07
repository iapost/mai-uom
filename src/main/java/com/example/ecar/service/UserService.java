package com.example.ecar.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecar.model.Client;
import com.example.ecar.model.Credentials;
import com.example.ecar.model.Dealership;
import com.example.ecar.repository.ClientRepository;
import com.example.ecar.repository.CredentialsRepository;
import com.example.ecar.repository.DealershipRepository;

@Service
public class UserService {

	@Autowired
	private CredentialsRepository credsRepo;

	@Autowired
	private ClientRepository clientRepo;

	@Autowired
	private DealershipRepository dealershipRepo;

	// OK
	// sygkrinoume ta creds poy irthan me tin klisi tis mehtodou me ola ta creds pou
	// yparxoun stin vasi. Se periptosi pou vrethei omoiotita epistrefetai olo to
	// antikeimeno gia na eksetasei to front end ton rolo
	// kai analoga na kanei redirect.
	// TODO handle se periptosi lathous creds
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

//	public Credentials login(Credentials attemtedCreds) throws Exception {
//
//		List<Credentials> allCreds = credsRepo.findAll();
//		Credentials verifiedCreds = null;
//		for (Credentials c : allCreds) {
//			if (c.getUsername().equals(attemtedCreds.getUsername())
//					&& c.getPassword().equals(attemtedCreds.getPassword())) {
//				
//				verifiedCreds = c;
//				break;
//			}
//		}
//
//		return verifiedCreds;
//	}

	// dokimi with session, to check he userid
	public int getUserId(int credsId) {

		List<Client> allClients = clientRepo.findAll();
		List<Dealership> allDealership = dealershipRepo.findAll();
		int userId = 0;
		for (Client c : allClients) {
			if (credsId == c.getCredentialsId()) {
				userId = c.getId();
				break;
			}
		}

		for (Dealership d : allDealership) {
			if (credsId == d.getCredentialsId()) {
				userId = d.getId();
				break;
			}
		}

		return userId;
	}

	// OK
	public void clientRegister(Map<String, Object> requestBody) {

		Map<String, Object> credentialMap = (Map<String, Object>) requestBody.get("credentials");
		Credentials creds = new Credentials();
		creds.setUsername((String) credentialMap.get("username"));
		creds.setPassword((String) credentialMap.get("password"));
		creds.setRole(Integer.parseInt(credentialMap.get("role").toString()));

		Optional<Credentials> byId = credsRepo.findById(creds.getId());
		if (!byId.isPresent())
			credsRepo.save(creds);

		Map<String, Object> clientMap = (Map<String, Object>) requestBody.get("client");
		Client client = new Client();
		client.setAfm(Integer.parseInt(clientMap.get("afm").toString()));
		client.setFname((String) clientMap.get("fname"));
		client.setSname((String) clientMap.get("sname"));
		client.setEmail((String) clientMap.get("email"));
		client.setCreds(creds);

		Optional<Client> byId2 = clientRepo.findById(client.getId());
		if (!byId2.isPresent())
			clientRepo.save(client);

	}

	// OK
	public void dealershipRegister(Map<String, Object> requestBody) {

		Map<String, Object> credentialMap = (Map<String, Object>) requestBody.get("credentials");
		Credentials creds = new Credentials();
		creds.setUsername((String) credentialMap.get("username"));
		creds.setPassword((String) credentialMap.get("password"));
		creds.setRole(Integer.parseInt(credentialMap.get("role").toString()));

		Optional<Credentials> byId = credsRepo.findById(creds.getId());
		if (!byId.isPresent())
			credsRepo.save(creds);

		Map<String, Object> dealershipMap = (Map<String, Object>) requestBody.get("dealership");
		Dealership dealership = new Dealership();
		dealership.setAfm(Integer.parseInt(dealershipMap.get("afm").toString()));
		dealership.setName((String) dealershipMap.get("name"));
		dealership.setOwner((String) dealershipMap.get("owner"));
		dealership.setCredentials(creds);

		Optional<Dealership> byId2 = dealershipRepo.findById(dealership.getId());
		if (!byId2.isPresent())
			dealershipRepo.save(dealership);
	}

}
