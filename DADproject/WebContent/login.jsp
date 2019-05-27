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
<title>HOME | LOGIN</title>
</head>
<body>
	<h1 align="center" style="color:black;">Login</h1>
	<h3 align="center" style="color: red;"> ${message}</h3>
	<form name="loginform" method="post" action="LoginServlet">
		<table align="center" width="300px" height="200px">
			<tr>
				<td> Username :</td>
				<td><input type="text" name="username" required></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" name="password" required></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="Sign in"></td>
				<td><input type="reset" name="reset" value="Clear"></td>
			</tr>
			<tr>
				<td rowspan="2"><a href="registration.jsp">Create an account</a></td>
			</tr>
		</table>
	</form>
</body>
</html>