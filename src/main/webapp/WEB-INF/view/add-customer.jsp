<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add new customer</title>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />

</head>
<body>

<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
 
 	<div id="container">
		<h3>Save Customer</h3>
		
		<form:form action="saveCustomer" modelAttribute="customer" method="POST">
			
			<div>
				<label>First name</label>
				<form:input path="firstName" />
			</div>
			
			<div>
				<label>Last name</label>
				<form:input path="LastName" />
			</div>
			
			<div>
				<label>Email</label>
				<form:input path="email" />
			</div>
			
			<div>
				
				<input type="submit" value="save" class="save" />
			</div>
			
		</form:form>
		
		<div style="clear; both;"></div>
		
		<p>
		
			<a href="${pageContext.request.contextPath}/customer/list">Back to the list</a>
		</p>
		
	</div>
</body>
</html>