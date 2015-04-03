<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Topic</title>
</head>
<body>
	<c:set var="bean" scope="request" value="${deleteTopicBean}" />
	<h2>Delete Topic</h2>
	<c:choose>

		<c:when test="${deleteTopicBean.topics.size() == 0}">
			<h2>No topics to delete</h2>
		</c:when>
		<c:otherwise>
			<form method="POST" action="/JEE_ECP/jsp/DeleteTopic">
				<c:choose>
					<c:when test="${not deleteTopicBean.authorized }">
						<label for="token">Input code: </label>
						<input id="token" name="token" type="text" />
						<br />
						<br />
						<input type="submit" value="Send Token" />
					</c:when>
					<c:otherwise>
						<div>${deleteTopicBean.update()}</div>
						<p>
							Topics: <select name="topic">
								<c:forEach var="topic" items="${deleteTopicBean.topics}">
									<option value="${tema.id}">${topic.name}</option>
								</c:forEach>
							</select>
						</p>
						<br />
						<input type="submit" value="Delete topic" />
					</c:otherwise>
				</c:choose>
			</form>
		</c:otherwise>
	</c:choose>
	<a href="/JEE_ECP/Home.jsp">Back to Home</a>
	<br>
</body>
</body>
</html>