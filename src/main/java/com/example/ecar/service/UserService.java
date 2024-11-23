package com.example.ecar.service;

import java.sql.*;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	public void login(String username, String password) throws Exception {

		boolean verified = false;
		String myDriver = "org.gjt.mm.mysql.Driver";
		String myUrl = "jdbc:mysql://localhost/ecar";
		Class.forName(myDriver);
		Connection conn = DriverManager.getConnection(myUrl, "root", "");

		String query = "SELECT * FROM credentials";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);

		while (rs.next()) {
			if (username.equals(rs.getString("username")) && password.equals(rs.getString("password"))) {
				System.out.println("login ok");
				verified = true;
				break;
			}
		}

		if (verified == false)
			System.out.println("Invalid credentials");

		st.close();

		// des oti isxuon ta creds me erotima stin vasi. an nai syndeeis stin alli
		// othoni alla na kouvalaei to id

	}

	public int credentialRegister(String username, String password, int role) throws Exception {

		String myDriver = "org.gjt.mm.mysql.Driver";
		String myUrl = "jdbc:mysql://localhost/ecar";
		Class.forName(myDriver);
		Connection conn = DriverManager.getConnection(myUrl, "root", "");

		String query = "INSERT INTO credentials (username, password, id_role) VALUES (?, ?, ?)";

		PreparedStatement preparedStmt = conn.prepareStatement(query);
		preparedStmt.setString(1, username);
		preparedStmt.setString(2, password);
		preparedStmt.setInt(3, role);
		preparedStmt.execute();

		preparedStmt.close();
		
		String query2 = "SELECT c.id FROM credentials c WHERE c.username='" + username + "' AND password='" + password + "'";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query2);
		int creds_id = 0;
		while(rs.next()) {
			creds_id = rs.getInt("id");
			System.out.println("edo eisai" + creds_id);
			
		}
		return creds_id;
		

	}
	
	public void clientRegister(String name, String surname, String afm, String email, int creds_id) throws Exception {

		String myDriver = "org.gjt.mm.mysql.Driver";
		String myUrl = "jdbc:mysql://localhost/ecar";
		Class.forName(myDriver);
		Connection conn = DriverManager.getConnection(myUrl, "root", "");

		String query = "INSERT INTO client (afm, name, surname, email, creds_id) VALUES (?, ?, ?, ?, ?)";

		PreparedStatement preparedStmt = conn.prepareStatement(query);
		preparedStmt.setString(1, afm);
		preparedStmt.setString(2, name);
		preparedStmt.setString(3, surname);
		preparedStmt.setString(4, email);
		preparedStmt.setInt(5, creds_id);
		preparedStmt.execute();

		preparedStmt.close();

	}

}
