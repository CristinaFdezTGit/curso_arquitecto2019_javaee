<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="daos.DAOContactosImpl"
     import="java.util.List"  import="java.util.ArrayList"  import="model.Contacto" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:set var="listContacto" value="${requestScope.contactos}" />

<div>
<c:choose>
 <c:when test="${not empty requestScope.contactos}">
 
<table border="1">
<caption>Lista de Contactos</caption>
   <tr>
       <th></th>
       <th>Id</th>
       <th>Nombre</th>
       <th>Email</th>
       <th>Edad</th>
   </tr>
 
 <c:forEach var="lista"  items="${listContacto}">   
   
   <tr>
   <td>&nbsp;<a href="Controller?op=doEliminar&id=${lista.idContacto}" >eliminar</a> </td>
    <td> ${lista.idContacto}&nbsp; </td>   
   <td>&nbsp;${lista.nombre}&nbsp; </td>
   <td>&nbsp;${lista.email}&nbsp; </td>
   <td align="center">${lista.edad} </td>
 </tr>
    
 </c:forEach> 
 </table>
 
 </c:when>
 <c:otherwise>
  <h2>Sin contactos</h2>
 </c:otherwise>
</c:choose>
 </div>
<br>
<br>
<a href="entrada.html"> volver</a>


</body>
</html>