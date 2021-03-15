<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Application</title>
</head>
<body>
	<jsp:useBean id="i" type="java.lang.Integer" scope="application"></jsp:useBean>
	application var i : <%= i %>
</body>
</html>