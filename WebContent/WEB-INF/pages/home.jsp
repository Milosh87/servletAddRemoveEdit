<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1><%=session.getAttribute("logged") %></h1>
<a href="../WebApp01/login">logout</a>

<a href="../WebApp01/city?operation=all" >all city</a>
<a href="../WebApp01/city?operation=new">new city</a>
</body>
</html>