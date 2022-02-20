<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User list</title>
</head>
<body>
	<h1>User list</h1>
	
	<table border="1">
	
				<th>Id</th>
				<th>Username</th>
				<th>Role</th>

				<c:forEach var="user" items="${userList}">
					<tr>
	
						<td>${user.id}</td>
						<td>${user.username}</td>
						<td>${user.role}</td>

					</tr>
				</c:forEach>
			</table>
	
	
	<br><br>
	<form action="/admin" method="get">
		<input type="submit" value="Go back to admin page">
	</form>
</body>
</html>