package com.example.eCar.Models;

public class Appointment {
	
	private int id;
	private String time;
	private String date;
	private String reason;
	private Client client;
	private CarDealership carDealership;
	private Car car;
	
	
	public Appointment(int id, String time, String date, String reason, Client client, CarDealership carDealership,
			Car car) {
		super();
		this.setId(id);
		this.setTime(time);
		this.setDate(date);
		this.setReason(reason);
		this.setClient(client);
		this.setCarDealership(carDealership);
		this.setCar(car);
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getReason() {
		return reason;
	}


	public void setReason(String reason) {
		this.reason = reason;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public CarDealership getCarDealership() {
		return carDealership;
	}


	public void setCarDealership(CarDealership carDealership) {
		this.carDealership = carDealership;
	}


	public Car getCar() {
		return car;
	}


	public void setCar(Car car) {
		this.car = car;
	}

}
