
<%@page import="java.util.ArrayList"%>
<%@page import="com.jarvis.dad.crud.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	body { 
  background: url(image/background.jpg) ; 
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
}
	td {
		text-align: center;
	}
</style>
<meta charset="ISO-8859-1">
<title>WELCOME PAGE</title>
</head>
<body bgcolor="darkgray">
	<h1 align="center" style="color: green;">Hello ${message}  !!!!</h1>
	
	<h2 align="center" style="color: black;">Employee List</h2>
	<table border="1" width="100%">
		<tr><th>Employee ID</th><th>Name</th><th>Designation</th><th>Salary</th><th>Delete</th></tr>
	<%	
	List<Employee> list = (ArrayList<Employee>)request.getAttribute("employeelist");
		
	for(Employee employee: list) {
		 out.print("<tr><td>"+employee.getEmpid()+"</td><td>"+employee.getEmployeeNameString()+"</td><td>"+employee.getDepartmentString()+"</td><td>"+employee.getSalary()+"</td><td><a href='DeleteServlet?empid="+employee.getEmpid()+"'>delete</a></td></tr>");  
	}
	%>
	</table>
	<h3 align="center"><a href="addEmployee.jsp">Add Employee</a>&nbsp;&nbsp;&nbsp;<a href="login.jsp">Sign Out</a></h3>
</body>
</html>