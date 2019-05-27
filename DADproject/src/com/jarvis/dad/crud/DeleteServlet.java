package com.jarvis.dad.crud;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sidString = request.getParameter("empid");
		int empid = Integer.parseInt(sidString);
		EmployeeDaoImplementation employeeDaoImplementation = new EmployeeDaoImplementation();
		employeeDaoImplementation.deleteEmployee(empid);
		User user = new User();
		request.setAttribute("name",user.getNameString());
		response.sendRedirect("ViewServlet");
	}

}
