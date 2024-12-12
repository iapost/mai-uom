package com.example.ecar.model;
import javax.persistence.*;

@Entity
public class Credentials {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;
	private int role;

	public Credentials() {
		this.id = 0;
		this.username = "";
		this.password = "";
		this.role = 0;
		
	}
	public Credentials(int id, String username, String password, int role) {
		super();
		this.setId(id);
		this.setUsername(username);
		this.setPassword(password);
		this.setRole(role);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

}
