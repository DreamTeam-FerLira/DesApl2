<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Form</title>
</head>
<body>
	<form action="StudentController">
		<label>Name:</label><br>
		<input type = "text" name= "name" value = "${student.name}" /><br>
		
		<label>Age:</label><br>
		<input type = "number" name= "age" value = "${student.age}" /><br>
		
		<label>Num Control:</label><br>
		<input type = "number" name= "num_control" value = "${student.num_control}" /><br>
		
		<label>Sex:</label><br>
		<input type = "text" name= "sex" value = "${student.sex}" /><br>
		
		<label>Group:</label><br>
		<input type = "text" name= "group_student" value = "${student.group_student}" /><br>
		
		
		<input type = "submit" name = "btn_save" id="btn_save" value = "Save"/>
	</form>
</body>
</html>