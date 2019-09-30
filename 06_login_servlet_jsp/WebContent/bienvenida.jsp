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

<% Persona persona = (Persona) request.getAttribute("persona"); %>
		
		<h1>Bienvenido <%=persona.getNombre()%> a mi página</h1>
		<br/>
		<h2>usuario: <%=persona.getUsuario()%> </h2>
		<h2>email: <%=persona.getEmail()%> </h2>;
		<h2>edad:<%=persona.getEdad()%> </h2>
		<br/>
		<br/>
  	    <a href='formulario.html'>volver</a>



</body>
</html>