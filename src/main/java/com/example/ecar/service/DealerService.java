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
import com.example.ecar.model.CarDealership;

@Service
public class DealerService {

	List<Car> carList = new ArrayList<Car>();

	public void addCar(String brand, String model, String fuel, String engine, int seats, double price, String info,
			int amount, CarDealership cd) {

		// sindesi stin DB
		Car newCar = new Car(brand, model, fuel, engine, seats, price, info, amount, cd);

		// pare auto to car kai steilto stin DB me to id tou sigkekrimenou dealeship

	}

	public ArrayList<Car> viewCars(int id) {

		// get apo tin DB to car dealership me to sygkekrimeno id

		// CarDealership cd = new CarDealership();

		// get apo tin vasi ola ta cars me auto to id gia carDealership

		ArrayList<Car> carList = new ArrayList<Car>();

		// gia kathe car kane cars.add();

		return carList;

	}

	private void addtoDB(Car aCar) throws Exception {
		carList = new ArrayList<Car>();

		String myDriver = "org.gjt.mm.mysql.Driver";
		String myUrl = "jdbc:mysql://localhost/eCar";
		Class.forName(myDriver);
		Connection conn = DriverManager.getConnection(myUrl, "root", "");
		
		String queryForCD = "SELECT * FROM car_dealership WHERE id=" + aCar.getCarDealership().getId();

		String query = "INSERT INTO car VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement preparedStmt = conn.prepareStatement(query);
		preparedStmt.setString(1, aCar.getBrand());
		preparedStmt.setString(2, aCar.getModel());
		preparedStmt.setString(3, aCar.getFuel());
		preparedStmt.setString(4, aCar.getEngine());
		preparedStmt.setInt(5, aCar.getSeats());
		preparedStmt.setDouble(6, aCar.getPrice());
		preparedStmt.setString(7, aCar.getInfo());
		preparedStmt.setInt(8, aCar.getAmmount());
		//preparedStmt.setInt(9, );
		preparedStmt.execute();

	}

}
