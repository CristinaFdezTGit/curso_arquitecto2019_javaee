<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"   import="model.Persona" %>
    <!--%@page import="model.Persona"%-->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% Persona persona = (Persona) session.getAttribute("persona"); %>
<div align="center">		
		<h1>Bienvenido <%=persona.getNombre()%> a mi página</h1>
		<br/>
		<h2>usuario: <%=persona.getUsuario()%> </h2>
		<h2>email: <%=persona.getEmail()%> </h2>
		<h2>edad:<%=persona.getEdad()%> </h2>
		<br/>
		<br/>
</div>		
	
	
  	    <a href='formulario.html'>volver</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href='Cierre'>cerrar</a>&nbsp;




</body>
</html>