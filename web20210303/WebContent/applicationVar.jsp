<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Application Variable</title>
</head>
<body>
	<%
	Integer counter = (Integer) session.getAttribute("counter");
	String heading = null;

	if (counter == null) {
		counter = 1;
	} else {
		counter = counter.intValue() + 1;
	}

	session.setAttribute("counter", counter);

	Integer i = (Integer) application.getAttribute("i");

	if (i == null) {
		i = new Integer(1);
	} else {
		i = new Integer(i.intValue() + 1);
	}

	application.setAttribute("i", i);
	%>

	You have visited this page <%=counter%> times.<BR>
	This page has been visited by all users <%=i%> times.

</body>
</html>