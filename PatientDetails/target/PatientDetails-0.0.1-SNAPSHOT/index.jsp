<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Patient Managing Option</title>
</head>
<body>
	<h1>Patient Manager</h1>
	<h3>Patient Addition</h3>
	<form action="PatientManager" method="get">
		Name:<input type="text" name="name" /> <br> Age:<input
			type="text" name="age" /> <br> Address:<input type="text"
			name="address" /> <br> Prescription name: <input type="text"
			name="name1" /> <br> Description:<input type="text"
			name="description" /> <br> <input type="submit"
			value="Add Patient" name="btn" />
	</form>
	<br>
	<form action="PatientManager" method="get">
		<input type="text" name="update" /> Prescription name: <input
			type="text" name="name2" /> Description:<input type="text"
			name="descript" /> <input type="submit" value="Add more" name="btn2" />

	</form>
	<form action="PatientManager" method="get">
		<input name="search" type="text" /> <input name="btn3" type="submit"
			value="Search" />
	</form>
	<table>
		<tr>
			<td>Name</td>
			<td>Age</td>
			<td>Address</td>
		</tr>
		<c:forEach var="zip" items="${lol}">
			<tr>
				<td>${zip.name}</td>
				<td>${zip.age}</td>
				<td>${zip.Address}</td>
			</tr>

		</c:forEach>
	</table>
</body>
</html>