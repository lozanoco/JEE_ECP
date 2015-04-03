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
	<form method="POST" action="/JEE_ECP/jsp/DeleteTopic">
		<label for="token">Input code: </label> <input id="token" name="token"
			type="text" /> <br /> <br /> <input type="submit"
			value="Send Token" />

	</form>
	<a href="/JEE_ECP/Home.jsp">Back to Home</a>
	<br>
</body>
</body>
</html>