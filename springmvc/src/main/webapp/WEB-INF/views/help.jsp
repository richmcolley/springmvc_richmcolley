<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Help Page</title>
</head>
<body>

<% String name = (String)request.getAttribute("Name");
    Integer id = (Integer)request.getAttribute("id");
%>

<h1>Name is <%=name %></h1>
<h1>Id is <%=id %></h1>

</body>
</html>