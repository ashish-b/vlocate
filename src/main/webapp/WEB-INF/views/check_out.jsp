<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Check Out Status</title>
</head>
<body>
	<h1>Check Out Status </h1>
<h3>Check Out Successful!</h3>

<table>
<tr><td>Email Id:</td><td>${user_email}</td></tr>
<tr><td>Destination:</td><td>${destination}</td></tr>
<tr><td>Car Type:</td><td>${car_type}</td></tr>
</table>

<h4>Current States:</h4>
	<c:if test="${not empty trips}">
		<p>
			<c:forEach var="trip" items="${trips}">
				<c:out value="${trip}"/><br>
			</c:forEach>
		</p>
	</c:if>
	<c:if test="${empty trips}">
		<p>No trips found</p>
	</c:if>

	</body>
</html>
