<%@ page language="java" contentType="text/html; charset=UTF-16"
	pageEncoding="UTF-16"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-16">
<title>Flight Search Form</title>
</head>
<body>

	<h5 style="width: 50%; margin-left: 50%;">Hello ,
		${sessionScope.valid_user.firstname}</h5>
	<div style="width: 50%;margin-left: 25%;">
		<form method="post">
			<label>From</label> <input type="text" name="fromCity"> <label>To</label>
			<input type="text" name="toCity"> <label>Departure
				Date :</label> <input type="date" name="departureDate">
			 <input style="width: 50%;margin-left: 35%;margin-top: 10%;" type="submit" value="Search">
		</form>
	</div>
</body>
</html>