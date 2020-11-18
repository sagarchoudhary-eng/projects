<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%--import JSTL supplied core tag lib --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--import spring supplied JSP tag lib --%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>${requestScope.status}</h5>
	<h5>Hello , Admin , ${sessionScope.valid_user.name}</h5>
	

	<table style="background-color: cyan; margin: auto;">
	<caption>Vendor List</caption>
	<c:forEach var="v" items="${requestScope.vendor_list}">
		<tr>
			<td>${v.name}</td>
			<td>${v.email}</td>
			<td>${v.regAmount}</td>
			<td>${v.regDate}</td>
			<td><a href="<spring:url value='/admin/update?vid=${v.id}'/>">Update Vendor Details</a></td>
			<td><a href="<spring:url value='/admin/delete?vid=${v.id}'/>">Delete Vendor Details</a></td>
		</tr>
		</c:forEach>
		</table>
		<h5><a href="<spring:url value='/admin/add'/>">Add New Vendor Details</a></h5>
		<h5><a href="<spring:url value='/user/logout'/>">Log Out</a></h5>
</body>
</html>