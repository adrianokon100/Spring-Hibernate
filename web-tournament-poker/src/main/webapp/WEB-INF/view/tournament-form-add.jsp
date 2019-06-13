<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head>
 		<title>jQuery DatePicker</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
            $(function () {
                $("#datepicker").datepicker({ dateFormat: 'yy-mm-dd' });
            });
        </script>   
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

</body>


	<div id="wrapper">
		<div id="header">
			<h2>ToM - Tournament of Poker</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Save tournament</h3>
	
		<form:form action="saveTournament" modelAttribute="tournament" method="POST">
		
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
						<form:input id="datepicker" path="startDate" />
						
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
							<c:forEach var="tempPlace" items="${places}">
								<option value="${tempPlace.id}">${tempPlace.name}</option>
							</c:forEach>
						</select>		
																						
							
						<br><br>	
					</td>
				</tr>
				
				
				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Save tournament" /></td>
				</tr>
						
			</tbody>
	
		</form:form>
		
		<br>
		<input type="button" value="back to tournaments"
		 onclick="window.location.href='tournamentList'; return false;" />
	
	</div>	

</html>