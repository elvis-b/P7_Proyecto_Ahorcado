<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Failure</h2>
<% String id = request.getParameter("username"); %>
No se ha podido iniciar sesion con el usuario <%=id%>
</body>
</html>