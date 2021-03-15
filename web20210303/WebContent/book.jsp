<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book_JSP</title>
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");
	String s=request.getParameter("submit");
	%>
	<jsp:useBean id="list" class="java.util.ArrayList" scope="session"></jsp:useBean>
	<jsp:useBean id="book" class="Bean.Book" >
   		<jsp:setProperty name="book" property="*"/>
	</jsp:useBean>
	
	
	<% 
	if(s.equals("新增"))
		list.add(book);
	if(s.equals("修改")){
		int i=list.indexOf(book);
		
		if(i>=0){
			list.set(i, book);
		}else{
			out.print("找不到資料");
		}
	}
	%>
	
	<table border="1" width="50%">
	
	<%
	for(Object o:list){
		Bean.Book b=(Bean.Book)o;
	
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