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
	<table style="background-color: cyan; margin: auto;" border="1">
		<caption>Product List</caption>
		<c:forEach var="product" items="${requestScope.product_list}">
			<tr>
				<td>${product.productId}</td>
				<td>${product.name}</td>
				<td>${product.price}</td>
				<td>${product.creationDate}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>