<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%--session.getAttribute("cust") -- null  --session.setAttribute("cust",new CustomerBean()) --%>
<jsp:useBean id="cust" class="beans.CustomerBean" scope="session" />
<%--session.getAttribute("book") --null ---session.setAttribute("book",new BookBean()) --%>
<jsp:useBean id="book" class="beans.BookBean" scope="session" />

<body>
<%--session.getAttribute("cust").getMessage() : null  --%>
	<h5 style="color: red">${sessionScope.cust.message}</h5>
	<form action="<c:url value='validate.jsp'/>">
		<table style="background-color: cyan; margin: auto;">
			<tr>
				<td>Enter User Email</td>
				<td><input type="text" name="email" /></td>
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