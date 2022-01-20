<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="addUser">
	<input type="text" name="id">
	<input type="text" name="name">
	<input type="text" name="age">
	<input type="submit"><br>
	
	
</form>

<br>

<form action="getUser">
	<input type="text" name="id">
	<input type="submit"><br>
</form>

<br>


<form action="getUserByAge">
	<input type="text" name="age">
	<input type="submit"><br>
</form>

<form action="getSortedUsers">
	<input type="submit"><br>
</form>

</body>
</html>