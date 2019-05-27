<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<style type="text/css">
	body { 
  background: url(image/background.jpg) ; 
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
}
</style>
<title>Employee</title>
</head>
<body>
	<p><%= request.getParameter("errMsg") %></p>
	<h1 align="center" style="color:black;">Add Employee</h1>
		<form name="employeeform" method="post" action="SaveServlet">
		<table align="center" width="300px" height="200px">
			<tr>
				<td> Employee Name :</td>
				<td><input type="text" name="name" required></td>
			</tr>
			<tr>
				<td>Department :</td>
				<td>
					<select name="department" style="width:172px;">
						<option name="HR">HR</option>
						<option name="developer">Developer</option>
						<option name="Tester">Tester</option>
						<option name="Marketing">Marketing</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>Salary :</td>
				<td><input type="text" name="salary"></td>
			</tr>
			<tr>
				<td><input type="submit" name="addemployee" value="ADD"></td>
				<td><input type="reset" name="reset" value="Clear"></td>
			</tr>
			<tr>
				<td rowspan="2"><a href="ViewServlet">View Employees</a></td>
			</tr>
		</table>
	</form>
</body>
</html>