package com.example.ecar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecar.model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{

}
