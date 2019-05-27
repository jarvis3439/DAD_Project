package com.jarvis.dad.crud;

public interface UserDAO {
	
		public User getUser(String usernameString,String passworString);
		public int insertUser(User user);
}
