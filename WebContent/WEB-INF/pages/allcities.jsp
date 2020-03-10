

<%@page import="city.City"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>

  <html>
<head>
<title>Employee Details </title>
</head>
<body>
<h1><%=session.getAttribute("logged") %></h1>
<%
List<City> cities = (List<City>)request.getServletContext().getAttribute("cities");
String html = "<tr><td>Name</td><td>PTT</td><td>edit</td><td>remove</td></tr>";
for(City city:cities){
	html+="<tr> <td> "+city.getIme() + "</td><td>"+city.getPostanskiBroj() + "</td><td><a href='../WebApp01/city?operation=edit&ptt="+ city.getPostanskiBroj() + "&ime=" + city.getIme() + "'>EDIT</a></td>"+"<td><a href='../WebApp01/city?operation=remove&ptt="+ city.getPostanskiBroj() +"'>REMOVE</a></td></tr>";
}
%>
<table>
<%=html%>
</table>
<a href="../WebApp01/city?operation=back">back</a>
</body>

</html>

