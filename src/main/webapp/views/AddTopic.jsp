<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vote view</title>
<script type="text/javascript">
	function load() {
		if ("${addTopicBean.error}" === "true") {
			alert("Insert ERROR!!.Topic is already in the database.");
		}
	}
</script>
</head>
<body onload="load()">
	<c:set var="bean" scope="request" value="${addTopicBean}" />
	<h2>Add Topic</h2>
	<h5>Choose topic for vote: ${bean.topic.name}</h5>
	<form method="POST" action="/JEE_ECP/jsp/AddTopic">
		<label for="nombre">Name: </label>
		<input id="nombre" name="name" type="text" value="${bean.topic.name}" /><br />
		<label for="pregunta">Question: </label>
		<input id="pregunta" name="question" type="text" value="${bean.topic.question}" /><br />
		<br /> <input type="submit" value="Add topic" />
	</form>
</body>
</body>
</html>