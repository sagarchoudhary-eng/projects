<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-16">
<title>Passenger Details Form</title>
</head>
<body>
	<h5 style="width: 50%;margin-left: 35%;">Hello , ${sessionScope.valid_user.firstname}</h5>
	<h5 style="width: 50%;margin-left: 35%;">
		You have Selected :
		<c:forEach var="f" items="${sessionScope.flight_list}">
			<tr>
				
				<td><label>Airline :</label>${f.flightName},</td>
				
				<td><label>Departure city :</label>${f.fromCity},</td>
				
				<td><label>Departure time :</label>${f.departureTime},</td>
				
				<td><label>Arrival :</label>${f.toCity}</td>
			</tr>
		</c:forEach>
	</h5>
	
	<form  method="post">
		<table style="background-color: cyan; margin: auto;">
			<tr>
				<td>Enter Passenger Name</td>
				<td><input type="text" name="firstName" /></td>
			</tr>
			<tr>
				<td>Enter User Email</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>Enter Address</td>
				<td><input type="text" name="address" /></td>
			</tr>
			<tr>
				<td>Enter Passport Number</td>
				<td><input type="text" name="passportNumber" /></td>
			</tr>
			<tr>
				<td>Enter Phone Number</td>
				<td><input type="text" name="phoneNumber" /></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Enter Details" /></td>
			</tr>
			<input type="hidden" name="id" value="${requestScope.passenger.flightId}">
		</table>
	</form>

</body>
</html>