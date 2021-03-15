<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL CHoose</title>
</head>
<body>
	<UL>
		<c:forEach var="i" begin="1" end="9">
			<li>
			<c:out value="${i}"></c:out>
			<c:choose>
				<c:when test="${i<4}">(小)</c:when>
				<c:when test="${i<7}">(中)</c:when>
				<c:otherwise>(大)</c:otherwise>
			</c:choose>				
		</c:forEach>
	</UL>
</body>
</html>