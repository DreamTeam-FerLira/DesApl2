<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sessions</title>
</head>
<body>
	<table border= "1">
		<tr>
			
			<th>
			
				<form action="SessionsController">
				
					<input type = "submit" name = "btn_new" value = "New"/>
				</form>
			 </th>
			 <th>Id</th>
			 <th>SessKey</th>
			 <th>Secret</th>
			  <th>Expiry</th>
			  <th>Data</th>
			
		</tr>
		<c:forEach var="sessions" items="${sessions1}">
		
		<tr>
			<td>
				<form action= "SessionsController">
					<input type = "hidden" name = "id" value= "${sessions.sessionId}">
					<input type = "submit" name= "btn_edit" value= "Edit" />
					<input type = "submit" name= "btn_delete" value= "Delete">
				</form>
			</td>
			<td> ${sessions.sessionId}</td>
			<td> ${sessions.sessKey}</td>
			<td> ${sessions.secret}</td>
			<td> ${sessions.expiry}</td>
			<td> ${sessions.data}</td>
		
		</tr>
		
		</c:forEach>
		
	
	</table>

</body>
</html>