<%@page import="sun.awt.EmbeddedFrame" %>
<%@page import="java.util.Iterator" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous"><style>

<title>Insert title here</title>
<style>

#main{
width:80%;
margin-left: auto; 
margin-right: auto;
}

#customers {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

#customers td, #customers th {
    border: 1px solid #ddd;
    padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
    padding-top: 12px;
    padding-bottom: 12px;
    text-align: left;
    background-color: #4CAF50;
    color: white;
}
</style>
</head>
<body style="background-color:teal;">
<a href="Index.html">  <i class="fa fa-home fa-fw" aria-hidden="true"></i>&nbsp;</a>
</br>
</br>
<div id="main">
<h3>List Of Orders</h3>

<c:if test="${requestScope.ordlist !=null and not empty requestScope.ordlist }">

<table border="1" cellpadding="3" id="customers" align="center">
 <tr>
 <th>Username</th>
 <th>Stater</th>
 <th>Maincourse</th>
 <th>Dessert</th>
 </tr>
     
<c:forEach items="${requestScope.ordlist}" var="e">
        <tr>
     <td>${e.username}</td>
      <td>${e.starter}</td>
 <td>${e.maincourse}</td>
 <td>${e.dessert}</td>
     </tr>
      </c:forEach> 
         
</table></c:if>
</div>
 </body>
</html>










