<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Form</title>
</head>
<body>
	<form action="EmployeeController">
		<label>Name:</label><br>
		<input type = "text" name= "name" value = "${employee.name}" /><br>
		
		<label>First Name:</label><br>
		<input type = "text" name= "firstname" value = "${employee.firstname}" /><br>
		
		<label>Last Name:</label><br>
		<input type = "text" name= "lastname" value = "${employee.lastname}" /><br>
		
		<label>Salary:</label><br>
		<input type = "text" name= "salary" value = "${employee.salary}" /><br>
		
		<label>Gender:</label><br>
		<input type = "text" name= "gender" value = "${employee.gender}" /><br>
		
		<label>Attention:</label><br>
		<input type = "text" name= "attention" value = "${employee.attention}" /><br>
		
		<input type = "submit" name = "btn_save" id="btn_save" value = "Save"/>
	</form>
</body>
</html>