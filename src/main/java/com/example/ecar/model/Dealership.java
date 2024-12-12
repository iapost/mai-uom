package com.example.ecar.model;
import javax.persistence.*;

@Entity
public class Dealership {

	@Id
	private int id;
	private int afm;
	private String name;
	private String owner;
	private Credentials creds;
	
	public Dealership() {
		
	}

	public Dealership(int id, int afm, String name, String owner, Credentials creds) {
		super();
		this.setId(id);
		this.setAfm(afm);
		this.setName(name);
		this.setOwner(owner);
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

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Credentials getCreds() {
		return creds;
	}

	public void setCreds(Credentials creds) {
		this.creds = creds;
	}
}
