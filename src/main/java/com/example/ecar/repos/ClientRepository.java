package com.example.ecar.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecar.model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{

}
