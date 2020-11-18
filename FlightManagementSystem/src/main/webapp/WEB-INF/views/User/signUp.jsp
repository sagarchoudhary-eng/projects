<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up Page</title>
</head>
<body>
<h3 style="width: 50%;margin-left: 40%;">New User Create Your account </h3>
<form:form method="post" modelAttribute="user">
		<table style="background-color: cyan; margin: auto;">
			<tr>
				<td>Enter First Name</td>
				<td><form:input path="firstname" /></td>
			</tr>
			<tr>
				<td>Enter last Name</td>
				<td><form:input path="lastname" /></td>
			</tr>
			<tr>
				<td>Enter User Email</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>Enter username</td>
				<td><form:input path="username" /></td>
			</tr>
			<tr>
				<td>Enter Password</td>
				<td><form:password path="password" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Register User" /></td>
			</tr>
			</table>
			</form:form>

</body>
</html>