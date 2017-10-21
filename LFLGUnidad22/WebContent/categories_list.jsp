<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Categories</title>
</head>
<body>
	<table border= "1">
		<tr>
			
			<th>
			
				<form action="CategoryController">
				
					<input type = "submit" name = "btn_new" value = "New"/>
				</form>
			 </th>
			 <th>Id</th>
			 <th>categoryName</th>
			 <th>Description</th>
			 <th>Picture</th>
			 <th>Info</th>
			
		</tr>
		<c:forEach var="category" items="${categories}">
		
		<tr>
			<td>
				<form action= "CategoriesController">
					<input type = "hidden" name = "id" value= "${category.id}">
					<input type = "submit" name= "btn_edit" value= "Edit" />
					<input type = "submit" name= "btn_delete" value= "Delete">
				</form>
			</td>
			<td> ${category.id}</td>
			<td> ${category.categoryName}</td>
			<td> ${category.description}</td>
			<td> ${category.picture}</td>
			<td> ${category.info}</td>
		
		</tr>
		
		</c:forEach>
		
	
	</table>

</body>
</html>