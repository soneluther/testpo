<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="list" class="java.util.ArrayList" scope="session"></jsp:useBean>
<jsp:useBean id="book" class="Bean.Book" >
   <jsp:setProperty name="book" property="*"/>
</jsp:useBean>
<%list.add(book);%>
<table border="1" width="50%">
<%
   for(Object bks : list){
	   Bean.Book b=(Bean.Book)bks; 
%>
    <tr>
    <td><%=b.getBookname() %></td>
    <td><%=b.getAuthor() %></td>
    <td><%=b.getPrice() %></td>
    </tr>
<% } %>
</table>
</body>
</html>