<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="daos.DAOContactosImpl"
     import="java.util.List"  import="java.util.ArrayList"  import="model.Contacto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% List <Contacto> listContacto= (ArrayList <Contacto>) request.getAttribute("contactos"); %>

<table border="1">
<caption>Lista de Contactos</caption>
   <tr>
       <th></th>
       <th>Id</th>
       <th>Nombre</th>
       <th>Email</th>
       <th>Edad</th>
   </tr>
<%  for(Contacto lista:listContacto){ %>
 <tr>
   <td>&nbsp;<a href="Controller?op=doEliminar&id=<%=lista.getIdContacto()%> " >eliminar</a> </td>
    <td> <%=lista.getIdContacto()%>&nbsp; </td>
   
   <td>&nbsp;<%=lista.getNombre()%>&nbsp; </td>
   <td>&nbsp;<%=lista.getEmail()%>&nbsp; </td>
   <td align="center"><%=lista.getEdad()%> </td>
 </tr>
	
<%}%>
 
 </table>
<br>
<br>
<a href="entrada.html"> volver</a>


</body>
</html>