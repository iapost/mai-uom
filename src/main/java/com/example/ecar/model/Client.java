package com.example.ecar.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Client extends AuthenticatedUser {
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	//sxesi N-N me ton pinaka Car. Stin ousia dimiourgia pinaka Appointment
	@ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name="appointment", 
			   joinColumns = @JoinColumn(name="client_id"),
			   inverseJoinColumns = @JoinColumn(name="car_id"))
	private Set<Car> testDriveCars = new HashSet<Car>();
	
	//sxesi N-N me ton pinaka Car. Stin ousia dimiourgia pinaka Sale
	@ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name="sale", 
			   joinColumns = @JoinColumn(name="client_id"),
			   inverseJoinColumns = @JoinColumn(name="car_id"))
	private Set<Car> boughtCars = new HashSet<Car>();


	public Client() {
	}

	public Client(int afm, String password, String firstName, String lastName, String email) {
		super(afm, password);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setEmail(email);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Car> getTestDriveCars() {
		return testDriveCars;
	}

	public void setTestDriveCars(Set<Car> testDriveCars) {
		this.testDriveCars = testDriveCars;
	}

	public Set<Car> getBoughtCars() {
		return boughtCars;
	}

	public void setBoughtCars(Set<Car> boughtCars) {
		this.boughtCars = boughtCars;
	}

}
