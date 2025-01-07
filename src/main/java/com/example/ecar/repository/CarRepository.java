package com.example.ecar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.ecar.model.Car;

public interface CarRepository extends JpaRepository<Car, Integer> {
	
	@Query(
		"SELECT c FROM Car c " + 
		"WHERE (:brand IS NULL OR c.brand = :brand) " + 
		"AND (:model IS NULL OR c.model = :model) " +
		"AND (:fuel IS NULL OR c.fuel = :fuel) " +
		"AND (:seats IS NULL OR c.seats = :seats) " +
		"AND (:fromPrice IS NULL OR c.price >= :fromPrice) " +
		"AND (:toPrice IS NULL OR c.price <= :toPrice) " +
		"AND (:fromEngine IS NULL OR c.engine >= :fromEngine) " +
		"AND (:toEngine IS NULL OR c.engine <= :toEngine) ")
	List<Car> search(String brand, String model, String fuel, Integer seats, Double fromPrice, Double toPrice, Integer fromEngine, Integer toEngine);
	
	@Modifying
	@Transactional
	@Query(
		"Update Car c " + 
		"SET c.amount = c.amount - 1 " + 
		"WHERE c.id = :id " + 
		"AND c.amount > 0 ")
	int buyCar(int id); 

}
