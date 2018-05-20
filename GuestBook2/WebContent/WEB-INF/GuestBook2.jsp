<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GuestBook1</title>
</head>
<body>
<table border = "1">
<tr><th>Id</th><th>Name</th><th>Message</th></tr>
<c:forEach items="${entries}" var="entry">
<tr>
<td>${entry.id}</td>
<td>${entry.name}</td>
<td>${entry.message}</td>
<td><a href="EditEntry2?index=${entry.id}">Edit</a></td>
</tr>
</c:forEach>
</table>
<a href="AddComment2">Add comment </a> 

</body>
</html>