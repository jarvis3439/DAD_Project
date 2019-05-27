package com.jarvis.dad.crud;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO userdao = new UserDaoImplementation();
		String usernameString = request.getParameter("username");
		String passwordString = request.getParameter("password");
		User user = userdao.getUser(usernameString, passwordString);
		
		if(user == null) {
			user = new User();
			user.setNameString(request.getParameter("name"));
			user.setUsernameString(request.getParameter("username"));
			user.setPasswordString(request.getParameter("password"));
			user.setEmailString(request.getParameter("email"));
			userdao.insertUser(user);
			
			request.setAttribute("successMessage", "Registration Done please login to continue !!!");
			request.getRequestDispatcher("registration.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "User alredy exists please try with other username !!!");
			request.getRequestDispatcher("registration.jsp").forward(request, response);
		}
	}

}
