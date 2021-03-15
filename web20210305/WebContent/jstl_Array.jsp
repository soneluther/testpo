<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Array</title>
</head>
<body>
	<% 
	String [] words={"太妍", "潤娥", "順圭", "俞利", "孝淵"};
	pageContext.setAttribute("words", words);
	%>
	<H3>少女時代</H3>
	<ul>
		<c:forEach var="words" items="${words}">
		<li>
			<c:out value="${words}"></c:out>
		</li>
		</c:forEach>
	</ul>
	
	<br>
	
	<h3>國家</h3>
	<c:forEach var="country" items="Australia,Canada,Japan,Philippines,USA">
	<li>
		<c:out value="${country}"></c:out>
	</li>
	</c:forEach>
</body>
</html>