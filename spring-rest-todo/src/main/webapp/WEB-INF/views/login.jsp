<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>

<body>
	<form:form action="processlogin"  modelAttribute="user" method="POST">
		Username: <form:input path="username"/><br/><br/>
		Password: <form:input path="password" /><br/><br/>
		<input type="submit" value="submit">
	</form:form>
</body>
</html>