package com.example.eCar.Models;

public class Client {

	private int id;
	private int afm;
	private String name;
	private String surname;
	private String email;
	private Credentials creds;
	
	public Client(int id, int afm, String name, String surname, String email, Credentials creds) {
		super();
		this.setId(id);
		this.setAfm(afm);
		this.setName(name);
		this.setSurname(surname);
		this.setEmail(email);
		this.setCreds(creds);
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Credentials getCreds() {
		return creds;
	}

	public void setCreds(Credentials creds) {
		this.creds = creds;
	}
	
	

}
