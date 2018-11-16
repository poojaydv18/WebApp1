<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="Logout.jsp">LOGOUT</a>
<form action="DisplayCustomerServlet" method="post">
<input type="submit" value= "DISPLAY CUSTOMER">
</form>
<form action="DisplayOrderServlet" method="post">
<input type="submit" value= "DISPLAY ORDER">
</form>
</body>
</html>