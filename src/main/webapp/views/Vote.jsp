<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vote view</title>

</head>
<body>
	<c:set var="bean" scope="request" value="${Vote}" />
	<h2>Vote</h2>
	<div>${bean.update()}</div>
	<form method="POST" action="/JEE_ECP/jsp/Vote">
		<c:choose>
			<c:when test="${not empty bean.topic}">

				<label for="topic">Topic name: </label>
				<input id="topic" name="topic" type="text"
					value="${bean.topic.name}" readonly />
				<br />
				<input type="hidden" name="id" value="${bean.topic.id}" />
				<label for="question">Question: </label>
				<input id="question" name="question" type="text"
					value="${bean.topic.question}" readonly />
				<br />
				<p>
					Score: <select name="value">
						<c:forEach begin="0" end="10" varStatus="loop">
							<option value="${loop.current}">${loop.current}</option>
						</c:forEach>
					</select>
				</p>
				<br>
				<label for="">Education Level: </label>
				<select id="educationLevel" name="educationLevel">
					<c:forEach items="${bean.levelEducationList}" var="educationLevel">
						<option value="${educationLevel}">${educationLevel}</option>
					</c:forEach>
				</select>
				<br />
				<input type="submit" value="Vote" />
	</form>

	</c:when>
	<c:otherwise>
		<p>
			Choose topic for vote: <select name="id">
				<c:forEach var="topic" items="${bean.topics}">
					<option value="${topic.id}">${topic.name}</option>
				</c:forEach>
			</select>
		</p>
		<br />
		<input type="submit" value="SelecctTopic" />
	</c:otherwise>
	</c:choose>
	<p>
		<a href="/JEE_ECP/jsp/Home">Back to Home</a>
	</p>
</body>
</body>
</html>