<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vote view</title>
<script type="text/javascript">
		function change() {
			var value = document.getElementById("score").value
			document.getElementById("score_txt").innerHTML = "Score: " + value;
		}
		function load() {
			if(document.getElementById("score")){
		    	document.getElementById("score").addEventListener('change', change);
		    }
		}
	</script>
</head>
<body onload="load()">
	<c:set var="bean" scope="request" value="${voteBean}" />
	<h2>Vote</h2>
	<h5>Choose topic for vote: ${bean.topic.nombre}</h5>
	<form method="POST" action="/JEE_ECP/jsp/Vote">
		<input type="hidden" name="id" value="${bean.topic.id}" />
		<p>Question: ${bean.topic.question}</p>
		<br /> <label for="valoracion">Score: </label> <input type="range"
			id="score" name="score" value="0" min="0" max="10"> <span
			id="score_txt">Score: 0</span><br /> <label for="">: </label> <select
			id="education" name="education">
			<c:forEach items="${bean.levelEducationList}" var="educationLevel">
				<option value="${educationLevel}">${educationLevel}</option>
			</c:forEach>
		</select> <br /> <input type="submit" value="Vote" />
	</form>

</body>
</body>
</html>