 <%@ page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Demo</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>

<body>

	<%
		@SuppressWarnings("unchecked")
		List<String> list = (List<String>) request.getAttribute("ERROR");
		if (list != null) {
			for (String str : list) {
				out.println("<font color='red'>" + str.toUpperCase() + "</font><br/>");
			}
		}
		
	%>

	<div class="container">
		<h2>Add a new Customer</h2>
		<br />
		<br />
		<form action="SaveCustomer.do" style="width: 50%">
			<div class="form-group">
				<label for="name">Name:</label> <input type="text"
					class="form-control" id="name" name="name">
			</div>
			<div class="form-group">
				<label for="pwd">Type:</label> <input type="text"
					class="form-control" id="type" name="type">
			</div>
			<div class="form-group">
				<label for="pwd">Email:</label> <input type="email"
					class="form-control" id="email" name="email">
			</div>

			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>