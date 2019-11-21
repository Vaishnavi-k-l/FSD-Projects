<html>
<body>
<head>
	<title>Customer Demo</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
	<%-- <% --%>
	<!-- 	response.sendRedirect("ListCustomerController.do"); -->
	<!-- %> -->
	<div class="container">
		<h1>Sample program using Http Session</h1>

	<form action="LoginController" method="post">
		<div class="form-group">
				<label for="name">Name:</label>
				 <input type="text"
					class="form-control" id="name" name="uname">
		</div>
		
		<div class="form-group">
				<label for="name">Password:</label>
				 <input type="password"
					class="form-control" id="name" name="pass">
		</div>
		
		<br> <input type="submit" value="Login" class="btn btn-primary">
	</form>
	</div>
	

</body>
</html>
