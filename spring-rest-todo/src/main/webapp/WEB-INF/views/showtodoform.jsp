<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adding a todo</title>
</head>

<body>
	<form:form action="/todo/process" >
		Id: <form:input path="id"/><br/><br/>
		User: <form:input path="user" /><br/><br/>
		Description: <form:input path="description" /><br/><br/>
		Target Date: <form:input path="targetdate" /><br/><br/>
		is Done: <form:input path="isDone" /><br/><br/>
		<input type="submit" value="submit">
	</form:form>
</body>
</html>