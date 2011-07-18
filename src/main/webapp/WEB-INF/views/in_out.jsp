<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Car Check in/out</title>
</head>
<body>

<h1>Car Check In/Out Management</h1>


<form name="check_out" action="check_out" method="get">
<table>	
<tr><td>Employee Email:</td><td><input type="text" name="user_email" /></td></tr>
<tr><td>Destination:</td><td><input type="text" name="destination"/></td></tr>
<tr><td>Car type:</td><td><input type="text" name="car_type" /></td></tr>
<tr><td><input type="submit" value="Submit" /></td></tr>
</table>
</form> 

<form name="check_in" action="check_in" method="get">
<table>	
<tr><td>Employee Email:</td><td><input type="text" name="user_email" /></td></tr>
<tr><td><input type="submit" value="Submit" /></td></tr>
</table>
</form> 

</body>
</html>
