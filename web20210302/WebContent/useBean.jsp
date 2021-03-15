<%@page import="Bean.Test1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>use a JavaBean</title>
</head>
<body>
	<h1>class Test1_1</h1>
	<%
	Bean.Test1 bt1=new Bean.Test1();
	%>	
	<h2>message : <%=bt1.msg() %></h2>
	<br>
	
	<h1>class Test1_2</h1>
	<jsp:useBean id="bt2" class="Bean.Test1"></jsp:useBean>	
	<h2>message : <%=bt2.msg() %></h2>
	<br>
	
	<h1>class Test2</h1>	
	<jsp:useBean id="test2" class="Bean.Test2"></jsp:useBean>
	<h2>message1 : <jsp:getProperty property="message" name="test2"/></h2>
	<h2>setMessage : Hello L&M !!!</h2><jsp:setProperty property="message" name="test2" value="Hello L&M !!!"/>	
	<h2>message2 : <jsp:getProperty property="message" name="test2"/></h2>
	
	
</body>
</html>