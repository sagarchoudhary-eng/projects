<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>Hello , ${sessionScope.cust.validatedCustomer.name}</h5>
	<table style="background-color: cyan; margin: auto;" border="1">
		<caption>Cart Contents</caption>
		<c:forEach var="bk" items="${sessionScope.book.cartDetails}">
			<tr>
				<td>${bk.title}</td>
				<td>${bk.author}</td>
				<td>${bk.price}</td>
			</tr>
		</c:forEach>
		<tr>
			<td>Total Cart Value</td>
			<td>${sessionScope.book.total}</td>
		</tr>
	</table>
	<%--Clean up DAO --%>
	${sessionScope.cust.cleanUp()}
	${sessionScope.book.cleanUp()}
	<%--discard session --%>
	${pageContext.session.invalidate()}
	<h5>You have logged out....</h5>
	<h5>
		<a href="login.jsp">Visit Again</a>
	</h5>
</body>
</html>