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
public class Client{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//gia auto incement id
	private int id;
	private int afm;
	private String fname;
	private String sname;
	private String email;
	
	//sxesi 1-1 me ton pinaka credentials
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="credentials_id", referencedColumnName = "id")
	private Credentials credentials;
	
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

	public Client(int afm, String fname, String sname, String email) {
		this.setAfm(afm);
		this.setFname(fname);
		this.setSname(sname);
		this.setEmail(email);
	}
	
	public void setCreds(Credentials creds) {
		this.credentials = creds;
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

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCredentialsId() {
		return this.credentials.getId();
	}
}
