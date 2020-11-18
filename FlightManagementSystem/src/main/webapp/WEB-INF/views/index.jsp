<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome Page</title>
</head>
<body>
	<h3 style="width: 50%;margin-left: 35%;">Welcome to CDAC Flight Management System</h3>
	<h5 style="width: 50%;margin-left: 50%;"><a href="<spring:url value='/User/login'/>">User Login</a></h5>
	<h5 style="width: 50%;margin-left: 50%;"><a href="<spring:url value='/User/signUp'/>">Sign Up</a></h5>
</body>
</html>