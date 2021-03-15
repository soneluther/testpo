<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL IF</title>
</head>
<body>
	<UL>
		<c:forEach var="i" begin="1" end="9">
			<li>
				<c:out value="${i}" />
				<c:if test="${i>6}">
					(大於6)
				</c:if>
				
			</li>
		</c:forEach>
	</UL>
</body>
</html>