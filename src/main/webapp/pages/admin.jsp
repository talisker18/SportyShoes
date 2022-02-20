<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
</head>
<body>

	<h1>Admin Page</h1>
	<h2>See all users</h2>
	<form action="/admin/getAllUsers" method="get">
		<input type="submit" value="Go!">
	</form>
	<br>
	<h2>Search a user by name</h2>
	<form action="/admin/searchUser" method="get">
		Username: <input type="text" name="username"><br>
		<input type="submit" value="Search">
	</form>
	<h2>Manage products</h2>
	<form action="/admin/products" method="get">
		<input type="submit" value="Go!">
	</form>
	<br>
	<h2>See purchases</h2>
	<form action="/admin/purchaseFilter" method="get">
		<input type="submit" value="Go!">
	</form>
	<br>
	<h2>Change admin password</h2>
	<form action="/admin/changePassword" method="get">
		<input type="submit" value="Go!">
	</form>
	<br>
	
	<br><br>
	<form action="/" method="get">
		<input type="submit" value="Go to home">
	</form>
</body>
</html>