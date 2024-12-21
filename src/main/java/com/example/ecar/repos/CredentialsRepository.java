package com.example.ecar.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecar.model.Credentials;

public interface CredentialsRepository extends JpaRepository<Credentials, Integer>{

}
