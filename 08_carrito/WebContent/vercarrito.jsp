<%@page import="java.util.ArrayList" import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"   import="model.Producto"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% Producto producto = (Producto) session.getAttribute("producto"); 
  List<Producto> listaProduc =  (ArrayList <Producto>) session.getAttribute("listProductos");
  //ArrayList<Object[]> lista = (ArrayList<Object[]>)
		     %>

<form action="Operador"  method="POST">

<h1>PRODUCTO UNIDADES  PRECIO </h1>
<%  for(int i=0; i<listaProduc.size(); i++){ %>
	<h2><%=listaProduc.get(i).getNombreProducto()%>
    <%=listaProduc.get(i).getUnidades()%> <%=listaProduc.get(i).getPrecio()%>  </h2>
<%}%>
 
 <br/>
   <a href="Opciones.html">Volver</a>
</form>

</body>
</html>