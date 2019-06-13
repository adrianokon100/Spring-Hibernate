<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Tournaments for place </h2>
		</div>
	</div>
	

	<div id="container">
		<div id="content">
		
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
						
						
					</tr>
				
				<!-- loop over and print our customers -->
				
					<c:forEach var="tempTournament" items="${tournamentsForPlace}">
						
					
					<tr>						
						<td>${tempTournament.name}</td>
						<td>${tempTournament.maxPlayers}</td>
						<td>${tempTournament.minPlayers}</td>
						<td>${tempTournament.startDate}</td>
						<td>${tempTournament.startTime}</td>	
						<td>${tempTournament.place.name}</td>
																			
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