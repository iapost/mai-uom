package com.example.ecar.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ecar.model.Car;
import com.example.ecar.model.Dealership;

@Service
public class DealershipService {

	List<Car> carList = new ArrayList<Car>();

	public void addCar(Car car) {


		// pare auto to car kai steilto stin DB me to id tou sigkekrimenou dealeship

	}

	public ArrayList<Car> viewCars(int id) throws Exception {

			//pare ola ta cars kai kanta view

		return carList;

	}



}
