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
	<h3>Prescription Addition</h3>
	<form action="PatientManager" method="get">
	Enter the name of the patient:<input type="text" name="update" /><br> Prescription name: <input
			type="text" name="name2" /> <br>Description:<input type="text"
			name="descript" /> <br><input type="submit" value="Add more" name="btn2" />

	</form>
	<h3>Search Patient</h3>
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
				<td>${zip.address}</td>
						
				
			</tr>

		</c:forEach>
		
	</table>
	<table>
	<tr><td>Prescription Name</td><td>Prescription Description</td></tr>
	<c:forEach var="keys" items="${Prescribe}">
				<tr>
				<td>${keys.name}</td>
				<td>${keys.description}</td>
				</tr>
				</c:forEach>
</table>					
</body>
</html>