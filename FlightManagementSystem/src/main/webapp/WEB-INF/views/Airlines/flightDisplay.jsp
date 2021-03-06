<%@ page language="java" contentType="text/html; charset=UTF-16"
	pageEncoding="UTF-16"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-16">
<title>Display Flights</title>
</head>
<body>

	<table style="background-color: cyan; margin: auto;">
	<caption>Flight List</caption>
		<tr>
			<th>Airline</th>
			<th>Departure city</th>
			<th>Departure Time</th>
			<th>Arrival City</th>
		</tr>
	<c:forEach var="f" items="${sessionScope.flight_list}">
		<tr>
			<td>${f.flightId}</td>
			<td>${f.fromCity}</td>
			<td>${f.departureTime}</td>
			<td>${f.toCity}</td>
			<td><a href="<spring:url value='/passengerDetails?flightId=${f.flightId}'/>">Select</a></td>
		</tr>
		</c:forEach>
		</table>
</body>
</html>