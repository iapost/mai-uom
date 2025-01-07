package com.example.ecar.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Dealership extends AuthenticatedUser {

	private String name;
	
	private String owner;

	//sxesi 1-N me ton pinaka cars
	@OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Car> cars = new ArrayList<Car>();

	public Dealership() {

	}

	public Dealership(int afm, String password, String name, String owner) {
		super(afm, password);
		this.setName(name);
		this.setOwner(owner);
	}
	
	public void addCar(Car car) {
		cars.add(car);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

}
