<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<title>Model List</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
</head>

<body>
	<p>
		<font size="3" face="Verdana, Arial, Helvetica, sans-serif"><strong>Model
				List </strong></font>
	</p>
	<a href="ShoppingCart.jsp">View Cart</a>
	<p />
	<table width="75%" border="1">
		<thead>
			<tr>
				<th><strong>Model:</strong></th>
				<th><strong>Description:</strong></th>
				<th>Quantity</th>
				<th>Price</th>
				<th>Add to cart</th>
			
			</tr>
		</thead>
		<tbody>
			<tr>
				<form method="POST" action="CartController">
					<td>Apple<input type="hidden" name="modelNo"
						value="Apple">
					</td>
					<td>Good fibre<input type="hidden" name="description" value="Good fibre"></td>
					<td><input type="text" size="2" value="0" name="quantity"></td>
					<td>$10.00 <input type="hidden" name="price" value="10"> </td>
					<td><input type="hidden" name="action" value="add">
					<input type="submit" name="addToCart" value="Add To Cart"></td>
				</form>
				
			</tr>
			<tr>
				<form method="POST" action="CartController">
					<td>Mango<input type="hidden" name="modelNo"
						value="Mango">
					</td>
					<td>Seasonal Fruit<input type="hidden" name="description" value="Seasonal Fruit"></td>
					<td><input type="text" size="2" value="0" name="quantity"></td>
					<td>$20.00 <input type="hidden" name="price" value="20"> </td>
					<td><input type="hidden" name="action" value="add">
					<input type="submit" name="addToCart" value="Add To Cart"></td>
				</form>
				
				</td>
			</tr>
			<tr>
				<form method="POST" action="CartController">
					<td>Strawberry<input type="hidden" name="modelNo"
						value="Strawberry">
					</td>
					<td>Red coloured berry<input type="hidden" name="description" value="Red coloured berry"></td>
					<td><input type="text" size="2" value="0" name="quantity"></td>
					<td>$30.00 <input type="hidden" name="price" value="30"> </td>
					<td><input type="hidden" name="action" value="add">
					<input type="submit" name="addToCart" value="Add To Cart"></td>
				</form>
				
			</tr>
			<tr>
				<form method="POST" action="CartController">
					<td>Kiwi<input type="hidden" name="modelNo"
						value="Kiwi">
					</td>
					<td>Rich in Vitamin C<input type="hidden" name="description" value="Rich in Vitamin C"></td>
					<td><input type="text" size="2" value="0" name="quantity"></td>
					<td>$15.00 <input type="hidden" name="price" value="15"> </td>
					<td><input type="hidden" name="action" value="add">
					<input type="submit" name="addToCart" value="Add To Cart"></td>
				</form>
				
				
			</tr>
		</tbody>
	</table>
	<p></p>
</body>
</html>