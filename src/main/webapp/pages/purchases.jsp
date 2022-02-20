<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Purchase list</title>
</head>
<body>
	<h1>Purchase list</h1>
	
	<table border="1">
	
				<th>Purchase Id</th>
				<th>Purchase Date</th>
				<th>Category</th>
				<th>User Id</th>

				<c:forEach var="purchaseDto" items="${listWithPurchaseCategoryDto}">
					<tr>
	
						<td>${purchaseDto.purchaseId}</td>
						<td>${purchaseDto.purchaseDate}</td>
						<td>${purchaseDto.categoryText}</td>
						<td>${purchaseDto.userId}</td>

					</tr>
				</c:forEach>
			</table>
	
	
	<br><br>
	<form action="/admin" method="get">
		<input type="submit" value="Go back to admin page">
	</form>
</body>
</html>