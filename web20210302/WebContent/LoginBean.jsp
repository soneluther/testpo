<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LoginBean</title>
</head>
<body>
	<h1>Hello !!!</h1>
	<jsp:useBean id="user" class="Bean.LoginBean">
	<jsp:setProperty property="*" name="user"/>
	</jsp:useBean>
	
	Name : <jsp:getProperty property="username" name="user"/><br>
	Password : <jsp:getProperty property="password" name="user"/><br>
	Phone : <jsp:getProperty property="phone" name="user"/>
	
</body>
</html>