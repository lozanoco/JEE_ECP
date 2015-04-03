<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Votes</title>
</head>
<body>
	<c:set var="bean" scope="request" value="${ViewVotes}" />
	<h2>View Votes</h2>
	<div>${bean.process()}</div>
	<form action="/JEE_ECP/jsp/ViewVotes" method="post">
		<p>
			Topics: <select name="id" onchange="this.form.submit()">
				<c:if test="${ empty bean.topic}">
					<option value="default" selected></option>
				</c:if>
				<c:forEach var="topic" items="${bean.topics}">
					<c:choose>
						<c:when
							test="${not empty bean.topic && bean.topic.id == topic.id}">
							<option value="${topic.id}" selected>${topic.name}</option>
						</c:when>
						<c:otherwise>
							<option value="${topic.id}">${topic.name}</option>
						</c:otherwise>
					</c:choose>

				</c:forEach>
			</select>
		</p>
	</form>
	<c:if test="${not empty bean.topic}">
		<br>
		<label for="nVotes">Votes: </label>
		<input id="nVotes" type="text" value="${bean.nVotes}"
			readonly />
		<br />
		<br>
		<br>
		<br>
		<c:forEach var="educationLevel" items="${bean.educationLevel}">
			<c:if test="${bean.average.containsKey(educationLevel)}">
				<label for="educationLevel">Education level: </label>
				<input id="educationLevel" type="text" value="${educationLevel}"
					readonly />
				<br />
				<label for="average">Average: </label>
				<input id="notaMedia" type="text"
					value="${bean.average.get(educationLevel)}" readonly />
				<br />
				<br>
				<br>
			</c:if>

		</c:forEach>


	</c:if>
	<br>
	<p>
		<a href="/JEE_ECP/jsp/Home">Back to Home</a>
	</p>
</body>
</body>
</html>