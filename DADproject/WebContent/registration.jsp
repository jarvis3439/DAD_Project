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
</style>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
</head>
<body bgcolor="darkgray">
	<h1 align="center" style="color:black;">Registration</h1>
	<h3 align="center" style="color: red;"> ${message}</h3>
	<h3 align="center" style="color: green;"> ${successMessage}</h3>
	<form name="registrationform" method="post" action="RegistrationServlet">
		<table align="center" width="300px" height="400px">
			<tr>
				<td> Name :</td>
				<td><input type="text" name="name" required></td>
			</tr>
			<tr>
				<td> Username :</td>
				<td><input type="text" name="username" required></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" name="password" required></td>
			</tr>
			<tr>
				<td> Email :</td>
				<td><input type="email" name="email" required></td>
			</tr>
			<tr>
				<td><input type="submit" name="register" value="Register"></td>
				<td><input type="reset" name="reset" value="Clear"></td>
			</tr>
			<tr>
				<td rowspan="2"><a href="login.jsp">Back to login</a></td>
			</tr>
		</table>
	</form>
</body>
</html>