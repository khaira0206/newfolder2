<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action= "EditEntry1" method="post">
Name:<input type="text" name = "name" value="${entry.name}" >
<textarea name="message" rows="5" cols="60" >${entry.message}</textarea>
<input type="hidden" name="index" value="${entry.id}">
<input type="submit" name="add" value="Add">
</form>
</body>
</html>