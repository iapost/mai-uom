package com.example.ecar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecar.model.Credentials;

public interface CredentialsRepository extends JpaRepository<Credentials, Integer>{

}
