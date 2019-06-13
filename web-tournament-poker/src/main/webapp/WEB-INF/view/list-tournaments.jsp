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
			<h2>Tournaments</h2>
		</div>
	</div>
	

	<div id="container">
		<div id="content">
		
			<!-- put new button: Add Customer -->
			<br>
			<input type="button" value="Add Tournament"
			 onclick="window.location.href='tournamentFormAdd'; return false;" />	
			 <br><br><br>
			<!--  add our html table here -->
		
			<form:form action="searchTournament" method="POST">
				<input name="theSearchName" type="text" />
				<input type="submit" value="search" />
			</form:form>
		
				<table>
					<tr>
						<th>Name</th>
						<th>Max players</th>
						<th>Min players</th>	
						<th>Date</th>	
						<th>Time</th>
						<th>Name of the place</th>	
						<th>Delete / Update</th>	
						
						
					</tr>
				
				<!-- loop over and print our customers -->
				
					<c:forEach var="tempTournament" items="${tournaments}">
					
					<c:url var="deleteLink" value="/tournament/deleteTournament">
						<c:param name="tournamentId" value="${tempTournament.id}" />
					</c:url>	
					
					<c:url var="updateLink" value="/tournament/tournamentFormUpdate">
						<c:param name="tournamentId" value="${tempTournament.id}" />
					</c:url>	
					
					<tr>						
						<td>${tempTournament.name}</td>
						<td>${tempTournament.maxPlayers}</td>
						<td>${tempTournament.minPlayers}</td>
						<td>${tempTournament.startDate}</td>
						<td>${tempTournament.startTime}</td>	
						<td>${tempTournament.place.name}</td>
						
						<td>
							<a href="${deleteLink}">Delete</a>
							<a href="${updateLink}">Update</a>
						</td>
						<td>

					<%-- 	<form:form action="addTournamentForPlayer" method="POST" >
							<select name="idPlayer" ">							
								<c:forEach var="tempPlayer" items="${players}" >
									<option value="${tempPlayer.id}">${tempPlayer.firstName}</option>
								</c:forEach>
							</select>
						</form:form>	
					 --%>			
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