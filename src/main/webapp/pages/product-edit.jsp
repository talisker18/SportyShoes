<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit product</title>
</head>
<body>
	<h1>Edit product</h1>

		<form action="/admin/products/editProduct" method="get">
			<input type="hidden" id="shoeId" name="shoeId" value="${shoeCategory.shoeId}">
			Brand:<input type="text" name="shoeBrand" value="${shoeCategory.shoeBrand}"><br><br>
			Model:<input type="text" name="shoeModel" value="${shoeCategory.shoeModel}"><br><br>
			<label for="categoryText">Category:</label>
	       	<select name="categoryId" id="categoryId">
	        	<c:forEach items="${listWithAllCategories}" var="categoryFromList">
	        		<option value="${categoryFromList.id}" ${categoryFromList.id == shoeCategory.categoryId ? 'selected' : ''}>${categoryFromList.text}</option>
				</c:forEach>
			</select>
			<br><br>
			Price:<input type="text" name="price" value="${shoeCategory.price}"><br><br>
			<input type="submit" value="Update">
		</form>
		 
	
	<br><br><br>
	<form action="/admin" method="get">
		<input type="submit" value="Go back to admin page">
	</form>
</body>
</html>