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
	<h2>Delete Topic</h2>
	<div>${bean.update()}</div>
	<form action="/JEE_ECP/jsp/ViewVotes" method="post">
		
	<p>
		<a href="/JEE_ECP/jsp/Home">Back to Home</a>
	</p>
</body>
</body>
</html>