<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="Beans.simpleEmp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		ArrayList<simpleEmp> list=new ArrayList<>();
		list=(ArrayList<simpleEmp>)session.getAttribute("emps");
		for(simpleEmp semps:list){					
	%>
	<table border="1">
		<tr>
		<td><%= semps.getId() %></td>
		<td><%=semps.getLastName() %></td>
		<td><%=semps.getFirstName() %></td>
		<td><%=semps.getEmail() %></td>
		</tr>
	<%
		}
	%>
	</table>
</body>
</html>
