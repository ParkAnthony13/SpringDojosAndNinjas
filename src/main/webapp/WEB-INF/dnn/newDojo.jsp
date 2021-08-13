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
			<h1>New Person</h1>
			<form:form action="/dojos/new" method="post" modelAttribute="dojo">
			    <p>
			        <form:label path="name">Dojo Name</form:label>
			        <form:errors path="name" style="color:red;"/>
			        <form:input path="name" type="text"/>
			    </p>
			    <input type="submit" value="Create Dojo" class="btn btn-dark"/>
			</form:form>
			<a href="/ninjas/new">Create New Ninja</a>
		</div>
		<div class="container">
				<h1>All Dojos in Database</h1>
				<table class="table">
				    <thead>
				        <tr>
				            <th>Dojos</th>
				        </tr>
				    </thead>
				    <tbody>
				        <c:forEach items="${dojos}" var="dojo">
				        <tr>
				            <td><a href="/dojos/${dojo.id}"><c:out value="${dojo.name}"/></a></td>
				        </tr>
				        </c:forEach>
				    </tbody>
				</table>
			</div>
		
		<script src="/webjars/jquery/jquery.min.js"></script>
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/app.js"></script>
	</body>
</html>