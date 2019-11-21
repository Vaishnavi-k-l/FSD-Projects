<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html lang="en">
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
<body>

 <%
      if (session != null) {
    	  out.println(session.getId());
         if (session.getAttribute("user") != null) {
            String name = (String) session.getAttribute("user");
            out.print("Hello, " + name + "  Welcome to ur Profile");
         } else {
            response.sendRedirect("index.jsp");
         }
      }
   %>
	
	<form action = "LogoutController">
			<input type="submit" name ="submit" value ="LOGOUT" class ="btn btn-primary">
	</form>
	<br/>

	<div class="container">
		<h2>CRM-Customer Relationship Management</h2>
		<br />
		<br /> <input  class ="btn btn-primary" type="button" value='Add Customer'
			onclick="window.location.href = 'addcustomer.jsp'; return false;"
			class="add-button" /> <br />
		<br />
		
		<form action = "search.do">
			<input type="text" name ="search-what"/>
			<input type="submit" name ="submit" value ="Search" class ="btn btn-primary">
		</form>
		<br/>
		
		
		<form action = "sorting.do">
			<select name = "sort_type">
				<option value="ascending">Sort in ascending order</option>
				<option value="descending">Sort in desscending order</option>
			</select>
			<input type="submit" name ="sort" value ="Sort Data" class ="btn btn-primary">
		</form>
		<br/>
		
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Name</th>
					<th>Type</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="tempCustomer" items="${customers}">
					
					<c:url var="deleteLink" value="deletecustomer.do">
						<c:param name="customerId" value="${tempCustomer.cust_id}" />
					</c:url>
					
					<c:url var="updateLink" value="update-form.jsp">
						<c:param name="customerId" value="${tempCustomer.cust_id}" />
					</c:url>
					
					<tr>
						<td >${tempCustomer.name}</td>
						<td >${tempCustomer.type}</td>
						<td  >${tempCustomer.email}</td>
						
						<td><a href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>	
<%-- 						<a href="${editRow(i)}" id="editrow"+i>Update</a></td> --%>
						<a href="${updateLink}">Update</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>

</body>
</html>