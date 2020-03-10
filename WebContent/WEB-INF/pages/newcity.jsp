<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Add new city</h1>
<%


String error = "";
if(request.getAttribute("error") !=null){
	error = (String) request.getAttribute("error");
}

String ptt="";
if(request.getAttribute("ptt") !=null) {
	ptt = (String) request.getAttribute("ptt");
}
String ime="";
if(request.getAttribute("ime") !=null) {
	ime = (String) request.getAttribute("ime");
}

%>
<form method="post" action="../WebApp01/city">
ime <input name="ime" type="text" value='<%=ime%>'/>
<br>
ptt <input name="ptt" type="text" value='<%=ptt%>'/>
<br>
 <input type="hidden" name="hidden" value="new" type="text"/>
 <input type="submit" name="submit"/>
<%=error %>
</form>
<a href="../WebApp01/city?operation=back">back</a>
</body>
</html>