<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Users</title>
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
<c:forEach var="users" items="${users}" >
                <tr>
<td>${users.ID}</td>
<td>${users.Name}</td>
<td>${users.Decr}</td><td>${users.Catagory}</td><td>${users.Color}</td>
<td>${users.Material}</td>
<td>${users.Shape}</td>
<td>${users.Origin}</td>
</tr>
            </c:forEach> 
</tbody>
</table> 
</body>
</html>