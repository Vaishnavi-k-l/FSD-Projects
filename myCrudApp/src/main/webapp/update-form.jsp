 <%@ page import="java.util.List"%>


<!DOCTYPE html>
<html>

<head>
<title>Update Customer</title>
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

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container">
		<h3>Update Customer</h3>

		<!-- 		<form action="SaveCustomer.do" method="POST"> -->

		<!-- 			<table> -->
		<!-- 				<tbody> -->
		<!-- 					<tr> -->
		<!-- 						<td><label>Name:</label></td> -->
		<%-- 						<td><input name="name" type="text" value="${customer.name }" /></td> --%>
		<!-- 					</tr> -->

		<!-- 					<tr> -->
		<!-- 						<td><label>Type:</label></td> -->
		<%-- 						<td><input name="type" type="text" value="${customer.type}"/></td> --%>
		<!-- 					</tr> -->

		<!-- 					<tr> -->
		<!-- 						<td><label>Email:</label></td> -->
		<%-- 						<td><input name="email" type="text" value="${customer.email}"/></td> --%>
		<!-- 					</tr> -->

		<!-- 					<tr> -->
		<!-- 						<td><label></label></td> -->
		<!-- 						<td><input type="submit" value="Update" class="save" /></td> -->
		<!-- 					</tr> -->


		<!-- 				</tbody> -->
		<!-- 			</table> -->
		<!-- 		</form> -->


		<%
		@SuppressWarnings("unchecked")
		List<String> list = (List<String>) request.getAttribute("ERROR");
		if (list != null) {
			for (String str : list) {
				out.println("<font color='red'>" + str.toUpperCase() + "</font><br/>");
			}
		}
		
	%>

		<form action="update.do" style="width: 50%">
			<div class="form-group">
				<label for="name">Name:</label>
				 <input type="text"
					class="form-control" id="name" name="name">
			</div>
			<div class="form-group">
				<label for="type">Type:</label> <input type="text"
					class="form-control" id="type" name="type">
			</div>
			<div class="form-group">
				<label for="email">Email:</label> <input type="email"
					class="form-control" id="email" name="email">
			</div>
			<input type ="hidden" id ="Id" name = "customerId" value=<%= request.getParameter("customerId") %>>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>

		<div style=""></div>
		<p>
			<a href="ListCustomerController.do">Back to List</a>
		</p>

	</div>

</body>

</html>


