<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search User</title>
</head>
<body>
	<h1>Search User</h1>
	<h2>Result for username = ${search}:</h2>
	
	<p>Id = ${user.id}</p>
	<p>Role = ${user.role}</p><br>
	<br><br>
	<form action="/admin" method="get">
		<input type="submit" value="Go back to admin page">
	</form>
</body>
</html>