<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="div1" style="color:blue">
		Time
	</div>
	<script type="text/javascript">
		function getDate(){
			var d=document.getElementById("div1");
			var date=new Date();
			d.innerText=date.toLocaleTimeString();
		}
		
		window.setInterval(getDate, 1000);
	</script>
	
	<div>
		<form action="ELSubmit.jsp" method="post" onsubmit="return check()">
			user : <input type="text" id="user" name="user" value="Many" /><br/>
			<input type="submit" />
		</form>	
	</div>	
	<script type="text/javascript">
		function check(){
			var u=document.getElementById("user");
			
			if(u.value.length<5){
				alert("字串長度必須大於5");
				return false;
			}else{
				return true;
			}
		}
	</script>
		
</body>
</html>