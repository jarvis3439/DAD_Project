package com.jarvis.dad.crud;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnectionProvider implements MyConnection {
	
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(connectionUrlString, usernameString, passwordString);
		} catch (Exception e) {
			System.out.println(e);
		}
		return connection;
	}
}
