package com.jarvis.dad.crud;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO userdao = new UserDaoImplementation();
		String usernameString = request.getParameter("username");
		String passwordString = request.getParameter("password");
		User user = userdao.getUser(usernameString, passwordString);
		
		if (user != null && user.getNameString() != null) {
			request.setAttribute("message", user.getNameString());
			request.getRequestDispatcher("ViewServlet").forward(request, response);
		} else {
			request.setAttribute("message", "Data not Found please kindly register first !!!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
