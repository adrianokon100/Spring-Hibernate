<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>

<html>
<head>
	<title>List of athletes</title>
 
		<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css">		
		
	<link type="text/css"
			rel ="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/add-athlete-style.css">	

<!-- Another way for css

		<spring:url value="/resources/css/style.css" var="mainCss" />
		<link href="${mainCss}" rel="stylesheet" />
-->

</head>

<body>


	<div id="wrapper">
		<div id="header">
			<h2>This is a table of athletes</h2>
		</div>
	</div>
	
	
	<div id="container">
		<div id="content">
		
			<!-- add our html table here -->
			
			<input type="button" value="add customer"
				onclick="window.location.href='showFormForAdd'; return false;" />
			<br><br>
			
			<form:form action="searchAthlete" method="POST">
			
				<input type="text" name="theSearchName"/>
				<input type="submit" value="searchMe!" />				
			</form:form>
					
		
						
			<br>
			<table>
			
				<tr>
					<th>First name</th>
					<th>Last name </th>
					<th>Email</th>	
					<th>Action</th>
				</tr>
				
				<c:forEach var="tempAthlete" items="${athletes}">
				<tr>	
				
				<!-- construct an "update" link with athlete id -->
				<c:url var="updateLink" value="/athlete/showFormForUpdate">
					<c:param name="athleteId" value ="${tempAthlete.id}" />
				</c:url>
				
				<c:url var="deleteLink" value="/athlete/deleteAthlete">
					<c:param name="athleteId" value ="${tempAthlete.id}" />
				</c:url>
										
					<td>${tempAthlete.firstName}</td>
					<td>${tempAthlete.lastName}</td>
					<td>${tempAthlete.email}</td>
					<td>
					<a href="${updateLink}" >Update</a>
					|
					<a href="${deleteLink}" 
						onclick="return confirm('Are you sure you want to delete ${tempAthlete.firstName} ${tempAthlete.lastName}?');
						 return false;">Delete</a>
					</td>
										
				</tr>
				</c:forEach>
					
			</table>
			
		</div>
	</div>


</body>



</html>

