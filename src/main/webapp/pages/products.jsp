<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product list</title>
</head>
<body>
	<h1>Product list</h1>
	
	<table border="1">
	
				<th>Shoe Id</th>
				<th>Shoe Brand</th>
				<th>Shoe model</th>
				<th>Category</th>
				<th>Price</th>
				<th>Action</th>

				<c:forEach var="shoeCategory" items="${shoeCategoryList}">
					<tr>
	
						<td>${shoeCategory.shoeId}</td>
						<td>${shoeCategory.shoeBrand}</td>
						<td>${shoeCategory.shoeModel}</td>
						<td>${shoeCategory.categoryText}</td>
						<td>${shoeCategory.price}</td>
						<td>
							<form action="/admin/products/productForm" method="get">
								<input type="hidden" id="shoeId" name="shoeId" value="${shoeCategory.shoeId}">
								<input type="hidden" id="shoeBrand" name="shoeBrand" value="${shoeCategory.shoeBrand}">
								<input type="hidden" id="shoeModel" name="shoeModel" value="${shoeCategory.shoeModel}">
								<input type="hidden" id="categoryText" name="categoryText" value="${shoeCategory.categoryText}">
								<input type="hidden" id="price" name="price" value="${shoeCategory.price}">
								<input type="hidden" id="categoryId" name="categoryId" value="${shoeCategory.categoryId}">
								<input type="submit" value="Edit">
							</form>
						</td>

					</tr>
				</c:forEach>
			</table>
	
	
	<br><br>
	<form action="/admin" method="get">
		<input type="submit" value="Go back to admin page">
	</form>
</body>
</html>