<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Details</title>
</head>
<body> 
<table border="1" align="center" style="width:50%">
<thead><tr><th>Product Id</th><th>Product Name</th><th>Description</th>
<th>Category</th>
<th>Color</th>
<th>Material</th>
<th>Shape</th>
<th>Origin</th>
</tr>
</thead>
<tbody>
<tr>
<td>${user.ID}</td>
<td>${user.name}</td>
<td>${user.decr}</td>
<td>${user.catagory}</td>
<td>${user.color}</td>
<td>${user.material}</td>
<td>${user.shape}</td>
<td>${user.origin}</td>
</tr>
</tbody>
</table> 
</body>
</html>