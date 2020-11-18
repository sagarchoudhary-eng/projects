<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h5>Welcome 2 Spring Boot MVC</h5>
<h5><a href="<spring:url value='/user/login'/>">User Login</a></h5>
<%--to understand path variable --%>
<h5><a href="<spring:url value='/product/show/10/mango/100/2020-05-15'/>">Test Path variables</a></h5>
<h5><a href="<spring:url value='/product/show2/10/mango/100/2020-05-15'/>">variables with marshelling</a></h5>
</body>
</html>