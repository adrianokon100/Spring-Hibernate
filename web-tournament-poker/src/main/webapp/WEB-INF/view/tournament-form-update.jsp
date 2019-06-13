<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
</head>

   <style>
      .error {
         color: #ff0000;
      }

      .errorblock {
         color: #000;
         background-color: #ffEEEE;
         border: 3px solid #ff0000;
         padding: 8px;
         margin: 16px;
      }
   </style>

<body>
We are in the form for tournament update.. :)


</body>


	<div id="wrapper">
		<div id="header">
			<h2>ToM - Tournament of Poker</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Update Tournament</h3>
	
		<form:form action="updateTournament" modelAttribute="tournament" method="POST">
			<form:hidden path="id" />
			
		<form:errors path="*" cssClass = "errorblock" element = "div" /> 
		<br><br>	
		
		
			<tbody>
				<tr>
					<td><label>Name</label></td>
					<td>
						<form:input path="name" />
						<form:errors path="name" cssClass = "error" />
						<br><br>
					</td>
				</tr>
			
				<tr>
					<td><label>Max. players</label></td>
					<td>
						<form:input path="maxPlayers" />
						<form:errors path="maxPlayers" cssClass = "error" />
						<br><br>	
					</td>
				</tr>
				
				<tr>
					<td><label>Min. players</label></td>
					<td>
						<form:input path="minPlayers" />
						<form:errors path="minPlayers" cssClass = "error" />
						<br><br>	
					</td>
				</tr>

				<tr>
					<td><label>Start date</label></td>
					<td>
						<form:input path="startDate" />
						<form:errors path="startDate" cssClass = "error" />
						<br><br>
					</td>
				</tr>
				
				<tr>
					<td><label>Start time</label></td>
					<td>
						<form:input path="startTime" />
						<form:errors path="startTime" cssClass = "error" />
						<br><br>	
					</td>
				</tr>
				
				<tr>
					<td><label>Choose place</label></td>
					<td>
						<select name="placeTournament" >
							<c:forEach var="tempPlace" items="${places}" >
								<option value="${tempPlace.id}" >${tempPlace.name}</option>
							</c:forEach>		
						</select>
						<br><br>
					</td>
				</tr>
				
				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Update tournament" /></td>
				</tr>
						
			</tbody>
	
		</form:form>
		
		<br>
		<input type="button" value="back to tournaments"
		 onclick="window.location.href='tournamentList'; return false;" />
		
	
	</div>	

</html>