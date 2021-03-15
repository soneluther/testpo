<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employees List</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>Employee No.</th>
			<th>JobTitle</th>
			<th>ReportsTo</th>
			<th>OfficeCode</th>
			<th>LastName</th>
			<th>FirstName</th>
			<th>Extension</th>
			<th>E-mail</th>
		</tr>
		
		<c:forEach var="current" items="${ employees }">
			<tr>
			<td><c:out value="${ current.employeeNumber }"></c:out></td>
			<td><c:out value="${ current.jobTitle }"></c:out></td>
			<td><c:out value="${ current.reportsTo }"></c:out></td>
			<td><c:out value="${ current.officeCode }"></c:out></td>
			<td><c:out value="${ current.lastName }"></c:out></td>
			<td><c:out value="${ current.firstName }"></c:out></td>
			<td><c:out value="${ current.extension }"></c:out></td>
			<td><c:out value="${ current.email }"></c:out></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>