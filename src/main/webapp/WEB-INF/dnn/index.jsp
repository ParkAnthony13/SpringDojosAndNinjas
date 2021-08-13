<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<title>Insert title here</title>
	</head>
	<body>
		<div class="container">
			<h1><c:out value="${dojo.name}"/> Ninjas</h1>
			<table class="table">
			    <thead>
			        <tr>
			            <th>First Name</th>
			            <th>Last Name</th>
			            <th>Age</th>
			        </tr>
			    </thead>
			    <tbody>
			        <c:forEach items="${ninjas}" var="ninja">
				        <tr>
				            <td><c:out value="${ninja.firstName}"/></td>
				            <td><c:out value="${ninja.lastName}"/></td>
				            <td><c:out value="${ninja.age}"/></td>
				        </tr>
			        </c:forEach>
			    </tbody>
			</table>
			<a href="/">Home</a>
		</div>
		
		<script src="/webjars/jquery/jquery.min.js"></script>
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/app.js"></script>
	</body>
</html>