<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guess</title>
</head>
<body>
	<jsp:useBean id="Fortune" class="domain.GuessGameLogic" scope="session">
		<% Fortune.init(1, 10); %>
	</jsp:useBean>
	
	<%
	String guess=request.getParameter("guessNum");
	Integer guessNumber=Integer.parseInt(guess);
	
	if(Fortune.isCorrectNum(guessNumber)){
		session.invalidate();
	%><jsp:forward page="bingo.jsp"></jsp:forward>
	<%
	}else{
		int guessCount=Fortune.getGuessCountdown();
		
		if(guessCount>0){
			%> 數字 : <%=guess%>不正確<br>
			還有<%=guessCount%>次可以猜<br>
			<%=Fortune.getHint()%><br>
			<a href="guess.html">再試一次</a>
			<%
		}else{
			session.invalidate();
			%><jsp:forward page="noChances.jsp"></jsp:forward>
			<%
		}
	}
	%>
</body>
</html>