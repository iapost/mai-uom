package com.example.ecar.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.ecar.model.Car;
import com.example.ecar.model.CarDealership;

@Service
public class InitService {

	public void addCar(String brand, String model, String fuel, String engine, int seats, double price,
			String info, int amount, CarDealership carDealership) {
		
			Car newCar = new Car(brand, model, fuel, engine, seats, price, info, amount, carDealership);
			
			//pare auto to car kai steilto stin DB me to id tou sigkekrimenou dealeship
		
	}
	
	public ArrayList<Car> viewCars(int id){
		
		//get apo tin DB to car dealership me to sygkekrimeno id
		
		//CarDealership cd = new CarDealership();
		
		//get apo tin vasi ola ta cars me auto to id gia carDealership
		
		ArrayList<Car> carList = new ArrayList<Car>();
		
		//gia kathe car kane cars.add();
		
		return carList;
				
				
		
	}
}
