<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Player Form</title>
</head>
<body>
	<form action="SessionsController">
		<label>Session ID:</label><br>
		<input type = "text" name= "sessionId" value = "${sessions.sessionId}" /><br>
		
		<label>Sess Key:</label><br>
		<input type = "text" name= "sessKey" value = "${sessions.sessKey}" /><br>
		
		<label>Secret:</label><br>
		<input type = "text" name= "secret" value = "${sessions.secret}" /><br>
		
		<label>Expiry:</label><br>
		<input type = "text" name= "expiry" value = "${sessions.expiry}" /><br>
		
		<label>Data:</label><br>
		<input type = "text" name= "data" value = "${sessions.data}" /><br>
		
		<input type = "submit" name = "btn_save" id="btn_save" value = "Save"/>
	</form>
</body>
</html>