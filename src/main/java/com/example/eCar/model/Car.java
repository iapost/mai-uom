package com.example.ecar.model;

import java.util.ArrayList;

public class Car {

	private int id;
	private String brand;
	private String model;
	private String fuel;
	private String engine;
	private int seats;
	private double price;
	private String info;
	private int amount;
	private CarDealership carDealership;
	
	
	//contructor for existing cars with DB id
	public Car(int id, String brand, String model, String fuel, String engine, int seats, double price, String info,
			int amount, CarDealership carDealership) {
		super();
		this.setId(id);
		this.setBrand(brand);
		this.setModel(model);
		this.setFuel(fuel);
		this.setEngine(engine);
		this.setSeats(seats);
		this.setInfo(info);
		this.setAmmount(amount);
		this.setCarDealership(carDealership);
	}

	//constructor for crating new cars without auto incremented id
	public Car(String brand, String model, String fuel, String engine, int seats, double price, String info,
			int amount, CarDealership carDealership) {
		this.setBrand(brand);
		this.setModel(model);
		this.setFuel(fuel);
		this.setEngine(engine);
		this.setSeats(seats);
		this.setInfo(info);
		this.setAmmount(amount);
		this.setCarDealership(carDealership);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public int getAmmount() {
		return amount;
	}

	public void setAmmount(int amount) {
		this.amount = amount;
	}

	public CarDealership getCarDealership() {
		return carDealership;
	}

	public void setCarDealership(CarDealership carDealership) {
		this.carDealership = carDealership;
	}

}
