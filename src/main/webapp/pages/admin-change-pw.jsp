<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change admin password</title>
</head>
<body>
	<h1>Change admin password</h1>

		<form action="/admin/passwordChangeValidation" method="get">
			<label for="newPassword">New password:</label>
			<input type="password" id="newPassword" name="newPassword"><br><br>

			<input type="submit" value="Change!">
		</form>
		 
	<br><br><br>
	<form action="/admin" method="get">
		<input type="submit" value="Go back to admin page">
	</form>
</body>
</html>