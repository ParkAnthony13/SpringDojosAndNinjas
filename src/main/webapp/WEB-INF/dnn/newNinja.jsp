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
		<title>New Ninja</title>
	</head>
	<body>
		<div class="container">
			<h1>New Ninja</h1>
			<form:form action="/ninjas/new" method="post" modelAttribute="ninja">
			    <p>
			        <form:label path="dojo">Select Dojo:</form:label>
			        <form:select path="dojo">
			        	
			        	<c:forEach items="${dojos}" var="dojo">
				        	<form:option value="${dojo}">
				        		<c:out value="${dojo.name}" />
				        	</form:option>			        	
			        	</c:forEach>
			        
			        </form:select>
			    </p>
			    <p>
			        <form:label path="firstName">First Name</form:label>
			        <form:errors path="firstName" style="color:red;"/>
			        <form:input path="firstName" type="text"/>
			    </p>
			    <p>
			        <form:label path="lastName">Last Name</form:label>
			        <form:errors path="lastName" style="color:red;"/>
			        <form:input path="lastName" type="text"/>
			    </p>
			    <p>
			        <form:label path="age">Age</form:label>
			        <form:errors path="age" style="color:red;"/>
			        <form:input path="age" type="number"/>
			    </p>
			    <input type="submit" value="Create Ninja" class="btn btn-dark"/>
			</form:form>
		</div>
		
		<script src="/webjars/jquery/jquery.min.js"></script>
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/app.js"></script>
	</body>
</html>