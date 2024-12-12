package com.example.ecar.model;
import javax.persistence.*;


@Entity
public class Appointment {

	@Id
	private int id;
	private String time;
	private String date;
	private String reason;
	private Client client;
	private Dealership dealership;
	private Car car;
	
	public Appointment() {
		
	}

	public Appointment(int id, String time, String date, String reason, Client client, Dealership carDealership,
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

	public Dealership getCarDealership() {
		return dealership;
	}

	public void setCarDealership(Dealership carDealership) {
		this.dealership = carDealership;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

}
