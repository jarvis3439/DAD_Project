package com.jarvis.dad.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImplementation implements UserDAO {

	static Connection connection;
	static PreparedStatement ps;
	@Override
	public User getUser(String usernameString, String passworString) {
		User user = null;
		connection = null;
		try {
			connection = MyConnectionProvider.getConnection();
			ps = connection.prepareStatement("select * from userdetails where username=? and password=?");
			ps.setString(1, usernameString);
			ps.setString(2, passworString);
			
			ResultSet resultSet = ps.executeQuery();
			
			if (resultSet.next()) {
				user = new User();
				user.setUserid(resultSet.getInt(1));
				user.setNameString(resultSet.getString(2));
				user.setUsernameString(resultSet.getString(3));
				user.setPasswordString(resultSet.getString(4));
				user.setEmailString(resultSet.getString(5));
			}
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return user;
	}

	@Override
	public int insertUser(User user) {
		int status = 0;
		try {
			connection = MyConnectionProvider.getConnection();
			ps = connection.prepareStatement("insert into userdetails(name, username, password, email) values(?, ?, ?, ?)");
			ps.setString(1, user.getNameString());
			ps.setString(2, user.getUsernameString());
			ps.setString(3, user.getPasswordString());
			ps.setString(4, user.getEmailString());
			
			status = ps.executeUpdate();
			connection.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

}
