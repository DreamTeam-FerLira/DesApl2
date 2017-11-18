<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student</title>
</head>
<body>
	<table border= "1">
		<tr>
			
			<th>
			
				<form action="EmployeeController">
				
					<input type = "submit" name = "btn_new" value = "New"/>
				</form>
			 </th>
			 <th>Id</th>
			 <th>Name</th>
			 <th>firstname</th>
			 <th>lastname</th>
			 <th>Salary</th>
			 <th>Gender</th>
			 <th>Attention</th>
			 
			
		</tr>
		<c:forEach var="employee" items="${employees}">
		
		<tr>
			<td>
				<form action= "EmployeeController">
					<input type = "hidden" name = "id" value= "${employee.id}"/>
					<input type = "submit" name= "btn_edit" value= "Edit" />
					<input type = "submit" name= "btn_delete" value= "Delete"/>
				</form>
			</td>
			<td> ${employee.id}</td>
			<td> ${employee.name}</td>
			<td> ${employee.firstname}</td>
			<td> ${employee.lastname}</td>
			<td> ${employee.salary}</td>
			<td> ${employee.gender}</td>
			<td> ${employee.attention}</td>
			
			
		</tr>
		
		</c:forEach>
		
	
	</table>
	<form action="EmployeeReport">
					<input type = "submit" name = "btn_reporte" value = "Reporte"/>
				</form>

</body>
</html>