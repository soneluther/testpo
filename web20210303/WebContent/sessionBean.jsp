<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JavaBean Session</title>
</head>
<body>
	<h1>Using Beans and Session Scope</h1>
	<jsp:useBean id="bean1" class="Bean.Counter" scope="session"></jsp:useBean>
	<%
	bean1.setCounter(bean1.getCounter()+1);
	%>
	The counter value is: <jsp:getProperty property="counter" name="bean1"/>
</body>
</html>