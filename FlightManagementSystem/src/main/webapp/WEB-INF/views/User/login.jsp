<%@ page language="java" contentType="text/html; charset=UTF-16"
	pageEncoding="UTF-16"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-16">
<title>Login Page</title>
</head>
<body>
<h5 style="color: red;">${requestScope.mesg}</h5>
	<h3 style="width: 50%;margin-left: 35%;">Welcome to CDAC Flight Management System</h3>
	<h3 style="width: 50%;margin-left: 42.5%;">LOGIN PAGE</h3>

	<form method="post">
		<table style="background-color: cyan; margin: auto;">
			<tr>
				<td>Enter User Email</td>
				<td><input type="email" name="email" placeholder="xyz@email.com"/></td>
			</tr>
			<tr>
				<td>Enter Password</td>
				<td><input type="password" name="password" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Login" /></td>
			</tr>
		</table>
	</form>
	
</body>
</html>