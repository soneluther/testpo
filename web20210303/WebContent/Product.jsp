<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Info</title>
</head>
<body>
	<jsp:useBean id="ASUS_ZF6" class="Bean.Product" scope="request"></jsp:useBean>
	ID:${ASUS_ZF6.id}<br>
	NAME:${ASUS_ZF6.name}<br>
	PRICE:${ ASUS_ZF6.price }
</body>
</html>