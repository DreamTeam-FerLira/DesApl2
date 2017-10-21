<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Categories Form</title>
</head>
<body>
	<form action="CategoriesController">
		<!--  <label>ID:</label><br>
		<input type = "text" name= "id" value = "${categories.id}" /><br>-->
		
		<label>Category Name:</label><br>
		<input type = "text" name= "categoryName" value = "${category.categoryName}" /><br>
		
		<label>Description:</label><br>
		<input type = "text" name= "description" value = "${category.description}" /><br>
		
		<label>Picture:</label><br>
		<input type = "text" name= "picture" value = "${category.picture}" /><br>
		
		<label>Info:</label><br>
		<input type = "text" name= "info" value = "${category.info}" /><br>
		
		<input type = "submit" name = "btn_save" id="btn_save" value = "Save"/>
	</form>
</body>
</html>