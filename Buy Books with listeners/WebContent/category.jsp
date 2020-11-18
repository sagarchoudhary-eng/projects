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
	<%--session.getAttribute("cust").getMessage() --%>
	<h5 style="color: green">${sessionScope.cust.message}</h5>
	<%-- session.getAttribute("cust").getValidatedCustomer().getName() --%>
	<h5>Hello , ${sessionScope.cust.validatedCustomer.name}</h5>
	<%-- session.getAttribute("book").getCategoryList() --%>
	<%-- <h5>Category  List : ${sessionScope.book.categoryList}</h5> --%>
	<form action="<c:url value='category_details.jsp'/>">
		<table style="background-color: cyan; margin: auto;">
			<tr>
				<td>Choose a Category</td>
				<td><select name="cat">
						<%--session.getAttribute("book").getCategoryList() --%>
						<c:forEach var="c" items="${sessionScope.book.categoryList}">
							<option value="${c}">${c}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td><input type="submit" value="Choose"></td>
			</tr>
		</table>
	</form>
	<h5>
		<a href="<c:url value='check_out.jsp'/>">Check Out</a>
	</h5>
</body>
</html>