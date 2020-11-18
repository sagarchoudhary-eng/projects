<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payment Page</title>
</head>
<body>

<form  method="post">
		<table style="background-color: cyan; margin: auto;">
			<tr>
				<td>Card number</td>
				<td><input type="number" name="cardNumber" /></td>
			</tr>
			<tr>
				<td>Enter Card Holder Name</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>Expire Date</td>
				<td><input type="date" name="expDate" /></td>
			</tr>
			<tr>
				<td>CVV</td>
				<td><input type="number" name="cvv" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Enter" /></td>
			</tr>
			<input type="hidden" name="id" value="${requestScope.savePassenger.id}">
		</table>
	</form>

</body>
</html>