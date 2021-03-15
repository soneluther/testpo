<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Array</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>Name</th>
			<th>Age</th>
		</tr>
		
		<c:forEach var="current" items="${ stds }">
			<tr>
			<td><c:out value="${ current.name }"></c:out></td>
			<td><c:out value="${ current.age }"></c:out></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>