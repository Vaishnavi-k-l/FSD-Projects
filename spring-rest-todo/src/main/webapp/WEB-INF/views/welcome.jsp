<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>


<body>
	<div id="wrapper">
		<div id="header">
			<h2>ToDo List</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Customer -->
		
			<input type="button" value="Add Todo "
				   onclick="window.location.href='/todo/todoform'; return false;"
				   class="add-button"/>
				   
		
			<input type="button" value="List Todo "
				   onclick="window.location.href='/todo/list'; return false;"
				   class="add-button"/>		
			
				
		</div>
	
	</div>
	
		
</body>
</html>