<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<html>
<head>



	<link type="text/css"
			rel ="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/add-tournament-style.css">

	<link type="text/css"
			rel ="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/style.css">
	



</head>


<body>


	<div id="wrapper">
		<div id="header">
			<h2>Players</h2>
		</div>
	</div>
	

	<div id="container">
		<div id="content">
		
			<!-- put new button: Add Customer -->
			
			<br>
			<input type="button" value="Add Player"
			 onclick="window.location.href='playerFormAdd'; return false;" />
			<br><br><br>
				

				
		<form:form action="searchPlayer" method="POST">
				<input name="thisName" type="text" />
				<input type="submit" value="search" />
		</form:form>		
			
			<!--  add our html table here -->
		
				<table>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>	
						<th>City</th>
						<th>Delete / Update</th>	
						
						
					</tr>
				
				<!-- loop over and print our customers -->
				
					<c:forEach var="tempPlayer" items="${players}">
					
						<tr>
						
						<!-- construct "delete" link with player id  -->	
						<c:url var="deleteLink" value="/player/deletePlayer">
							<c:param name="playerId" value="${tempPlayer.id}" />
						</c:url>
						
						<c:url var="updateLink" value="/player/playerFormUpdate">
							<c:param name="playerId" value="${tempPlayer.id}"></c:param>
						</c:url>	
						
							<td>${tempPlayer.firstName}</td>
							<td>${tempPlayer.lastName}</td>
							<td>${tempPlayer.email}</td>
							<td>${tempPlayer.city}</td>
							
							<td>
							
							<a href="${deleteLink}">Delete</a>
							
							<a href="${updateLink}">Update</a>
							
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