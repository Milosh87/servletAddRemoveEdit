<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String error = "";
if(request.getAttribute("error")!= null){
 error = (String) request.getAttribute("error");
}
%>
<form action="../WebApp01/login" method="post">
Username: <input type="text" id="user" name="user"/>
Password: <input type="password" id="pass" name="pass"/>
<input type="submit" value="login">
<%=error %>


</form>
</body>
</html>