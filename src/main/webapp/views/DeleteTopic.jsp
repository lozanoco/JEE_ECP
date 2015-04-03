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
	<div>${bean.update()}</div>
	<form action="/JEE_ECP/jsp/DeleteTopic" method="post">
		<p>Topics:</p>
		<select name="topic" >
			<c:forEach var="topic" items="${bean.topics}">
				<option value="${topic.id}">${topic.name}</option>
			</c:forEach>
		</select>
		<p>
			<input type="submit" value="Delete" />
		</p>
	</form>
	<p>
		<a href="/JEE_ECP/jsp/Home">Back to Home</a>
	</p>
</body>
</body>
</html>