package com.jarvis.dad.crud;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaveServlet
 */
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Employee employee = new Employee();
		EmployeeDaoImplementation employeeDaoImplementation = new EmployeeDaoImplementation();
		
		String nameString = request.getParameter("name");
		String departmentString = request.getParameter("department");
		String salaryString = request.getParameter("salary");
		int salary = Integer.parseInt(salaryString);
		
		employee.setEmployeeNameString(nameString);
		employee.setDepartmentString(departmentString);
		employee.setSalary(salary);
		
		int status = employeeDaoImplementation.addEmployee(employee);
		
		if(status > 0) {
			String errMsg=  "<h3 align='center' style='color:green'>Record saved successfully</h3>";
			request.setAttribute("errMsg", errMsg);
			response.sendRedirect("addEmployee.jsp?errMsg=" + URLEncoder.encode(errMsg, "UTF-8"));
		} else {
			out.print("Sorry !! unable to save record");
		}
		out.close();
	}

}
