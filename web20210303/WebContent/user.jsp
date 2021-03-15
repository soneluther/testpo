<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Session</title>
</head>
<body>
	username : <%=session.getAttribute("loginName") %><br>
	EL username : ${ sessionScope.loginName }
</body>
</html>