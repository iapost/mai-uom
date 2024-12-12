package com.example.ecar.model;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CredentialsRepository extends JpaRepository<Credentials, Integer>{
	
	Optional<Credentials> findByUsernameAndPassword(String username, String password);

}
