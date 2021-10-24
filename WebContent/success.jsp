<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.*" %>
<%@ page import="model.Palabra" %>
<%@ page import="model.Partida" %>
<%@ page import="model.ListaPalabras" %>
<%@ page import="dao.SQLPalabraDAO" %>
<%@ page import="dao.SQLPartidaDAO" %>
<%@ page import="dao.InterfazDAO" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Ahorcado</title>
	<style>
		table{
			border-collapse:collapse;
			
		}
		td {
			border:2px solid black;
		}
		h1{
			color:red;
		}
		
	</style>
</head>
<body>

<% String id = request.getParameter("username"); 
%>
<h1>Bienvenido <%=id%></h1>

<%
	SQLPalabraDAO query = new SQLPalabraDAO();
	List<Palabra> pal = query.getTodos();
	//System.out.println(pal);
	
	SQLPartidaDAO q = new SQLPartidaDAO();
	List<Partida> topPartidas = q.getTodos();
	//System.out.println(topPartidas);
	
	int maxPuntuacion = q.getMejor(id);
	//System.out.println("MEJOR "+maxPuntuacion);
	
	//for (Palabra p : ){
	//System.out.println(p);
	//}
%>
	<h2>MEJORES 5 PUNTUACIONES</h2>
	<table>
		<tr>
			<td>ID</td>
			<td>Usuario</td>
			<td>Fallos</td>
			<td>Puntuacion</td>
		</tr>
			<%
				for(Partida p : topPartidas){
					%>
						<tr>
							<td><%= p.getId() %></td>
							<td><%= p.getUid() %></td>
							<td><%= p.getFallos() %></td>
							<td><%= p.getPuntuacion() %></td>
						
						</tr>
						
					<% 
				}
				
			%>
		
	</table>
	<%
		if(maxPuntuacion==-1){
	%>
			<h2>Todavia no has jugado ninguna partida</h2>
	<% 
		} else {
	%>
			<h2>TU MEJOR PUNTUACION ES: <%= maxPuntuacion %></h2>	
	<%	
		}
	
	%>
	<h1>Nueva Partida</h1>
	<form action="ahorcadoGame" method="POST">
          <select name="dificultad">
				<option value="1">Facil</option>
				<option value="2" selected>Medio</option>
				<option value="3">Dificil</option>
			</select>
          <br><br>
          <button class="btn btn-lg btn-primary btn-block" type="submit" name="botonAcceso" placeholder="processRequest">Iniciar Partida</button>   
	</form>
	
	<h1>Salir</h1>
	<a href="login.jsp"><input type="button" value="Salir"></a>
</body>
</html>