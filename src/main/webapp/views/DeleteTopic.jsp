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
		<c:when test="${bean.authorized == true}">
			<h5>Choose topic to delete:</h5>
			<form method="POST" action="/JEE_ECP/jsp/DeleteTopic">
				<input type="hidden" name="authorization" value="${bean.authorized}" />
				<c:forEach items="${bean.Topic}" var="topic">
					<input type="radio" name="id" value="${topic.id}" />${topic.name}
							<br/>
				</c:forEach>
				<br/> <input type="submit" value="Delete" />
			</form>
		</c:when>
		<c:otherwise>
			<form method="POST" action="/JEE_ECP/jsp/DeleteTopic">
				<label for="authorization">Authorization code:</label> <input
					id="authorization" name="authorization" type="text"
					value="${bean.authorized}" /> <br /> <input type="submit"
					value="Send" />
			</form>
		</c:otherwise>
	</c:choose>

	<br />
	<br />
	<a href="/JEE_ECP/jsp/Home">Back to Home</a>
</body>
</body>
</html>