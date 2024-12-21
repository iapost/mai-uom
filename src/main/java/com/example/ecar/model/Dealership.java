package com.example.ecar.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Dealership {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// gia auto increment id
	private int id;
	private int afm;
	private String name;
	private String owner;

	// sxesi 1-1 me ton pinaka credentials
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "credentials_id", referencedColumnName = "id")
	private Credentials credentials;

	@OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Car> cars = new ArrayList<Car>();

	public Dealership() {

	}

	public Dealership(int afm, String name, String owner) {
		this.setAfm(afm);
		this.setName(name);
		this.setOwner(owner);
	}
	
	public void setCredentials(Credentials creds) {
		this.credentials = creds;
	}

	public void addCar(Car car) {
		cars.add(car);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAfm() {
		return afm;
	}

	public void setAfm(int afm) {
		this.afm = afm;
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
