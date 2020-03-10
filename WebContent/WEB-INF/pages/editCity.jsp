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
String ptt = (String) request.getAttribute("ptt");
String ime = (String) request.getAttribute("ime");

%>
<form method="post" action="../WebApp01/city">
ime <input name="editovanoIme" type="text" value='<%=ime%>'>
	 <input type="hidden" name="hidden" value="edit" type="text">
	  <input type="hidden" name="ptt" value="<%=ptt%>" type="text">
<input type="submit" name="submit"/>
</form>
<a href="../WebApp01/city?operation=back">back</a>
</body>
</html>