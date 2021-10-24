<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>App Login Test</title>
</head>
<body>
	<H1>Inicie sesión más abajo</H1>
	<form action="login" method="POST">
          <input type="text" class="form-control" name="username" placeholder="username" required autofocus />
          <input type="password" class="form-control" name="password" placeholder="password" required=/>
          <button class="btn btn-lg btn-primary btn-block" type="submit" name="botonAcceso" placeholder="processRequest">Login</button>   
	</form>
</body>
</html>