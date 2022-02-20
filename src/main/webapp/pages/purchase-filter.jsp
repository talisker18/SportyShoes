<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search purchases</title>
</head>
<body>
	<h1>Search purchases</h1>

		<form action="/admin/purchases" method="get">
			<label for="dateFrom">Date from:</label>
			<input type="datetime-local" id="datepicker" name="dateFrom"><br><br>
			<label for="dateTo">Date to:</label>
			<input type="datetime-local" id="datepicker" name="dateTo"><br><br>
			
			<label for="categoryText">Category:</label>
	       	<select name="categoryId" id="categoryId">
	       		<option value="-1"></option>
	        	<c:forEach items="${categoryList}" var="category">
	        		<option value="${category.id}">${category.text}</option>
				</c:forEach>
			</select>
			<br><br>
			<input type="submit" value="Search">
		</form>
		 
	
	<br><br><br>
	<form action="/admin" method="get">
		<input type="submit" value="Go back to admin page">
	</form>
</body>
</html>