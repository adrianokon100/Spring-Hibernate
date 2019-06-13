<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>

<head>
	<title>Save the athlete</title>
	
	<link type="text/css"
			rel ="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/style.css">
			
		
	<link type="text/css"
			rel ="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/add-athlete-style.css">	
	
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>ARM - Athletes Relationship Manager</h2>
		</div>	
	</div>

<div id="container">
	<form:form action="saveAthlete" modelAttribute="athlete" method="POST">
		<form:hidden path="id"/>
	
		<table>
			<tr>
				<td><label>Name</label></td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td><label>Last name</label></td>	
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td><label>Email</label></td>	
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td><label></label></td>
				<td><input type="submit" value="save" /></td>
			</tr>
		</table>
	</form:form>
	
	<div style="clear; both;"></div>	
		<p>
			<a href="${pageContext.request.contextPath}/athlete/list" >Back to the list</a>
		</p>
</div>

</body>

</html>