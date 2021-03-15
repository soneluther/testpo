<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Map</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>NAME</th>
		</tr>
		
		<c:forEach var="current" items="${ authors }">
			<tr>
			<td><c:out value="${ current.id }"></c:out></td>
			<td><c:out value="${ current.name }"></c:out></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>