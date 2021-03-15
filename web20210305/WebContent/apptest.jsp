<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Appication Variable</title>
</head>
<body>
	<% application.setAttribute("user", "sone"); %>
	User : ${ applicationScope.user }
</body>
</html>