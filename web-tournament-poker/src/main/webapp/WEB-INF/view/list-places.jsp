<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>

    <link href="<c:url value="/resources/css/add-tournament-style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">


</head>


<body>


	<div id="wrapper">
		<div id="header">
			<h2>Places</h2>
		</div>
	</div>
	

	<div id="container">
		<div id="content">
		
			<!-- put new button: Add Place -->
			
			
			<br><br>
			<input type="button" value="Add Place"
			 onclick="window.location.href='placeFormAdd'; return false;" />
			<br><br><br>

			
			<form:form action="searchPlace" method="POST">
				<input name="theSearchName" type="text" />
				<input type="submit" value="search" />	
			</form:form>

				
			<!--  add our html table here -->
		
				<table>
					<tr>
						<th>Name</th>
						<th>City</th>
						<th>Description</th>
						<th>Tournaments</th>		
						<th>Delete / Update</th>	
								
					</tr>
				
				<!-- loop over and print our customers -->
				
					<c:forEach var="tempPlace" items="${places}">
					
					<c:url var="deleteLink" value="/place/deletePlace">
						<c:param name="placeId" value="${tempPlace.id}" />
					</c:url>	
					
					<c:url var="updateLink" value="/place/placeFormUpdate">
						<c:param name="placeId" value="${tempPlace.id}" />
					</c:url>	
					
					<c:url var="takeTournamentsLink" value="/place/takeTournamentsForPlace">
						<c:param name="placeId" value="${tempPlace.id}" />
					</c:url>
					
						<tr>				
						
							<td>${tempPlace.name}</td>
							<td>${tempPlace.city}</td>
							<td>${tempPlace.description}</td>
							<td><a href="${takeTournamentsLink}">Tournaments</a>	</td>
										
										
							<td>
							
							<a href="${deleteLink}" >Delete</a>
							
							<a href="${updateLink}" >Update</a>
							
							</td>			
																					
						</tr>
			
					</c:forEach>
		
		</table>
		
		<br>
		<input type="button" value="back to home"
		 onclick="window.location.href='/web-tournament-poker'; return false;" />
		
		</div>	
	</div>

</body>
</html>