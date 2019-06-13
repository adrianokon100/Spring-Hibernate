<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>

<head>

    <link href="<c:url value="/resources/css/add-tournament-style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    
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

	We are in the form.. :)

</body>


	<div id="wrapper">
		<div id="header">
			<h2>ToM - Tournament of Poker</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Save player</h3>
		
		<form:form action="savePlayer" modelAttribute="player" method="POST">
		
			<form:errors path="*" cssClass = "errorblock" element="div" />
		  		<br><br>
			
			
			<!-- need to associate this data with customer id-->
			<form:hidden path="id" />
			<tbody>
				<tr>
					<td><label>First name</label></td>
					<td><form:input path="firstName" />
					<font color = "red"><form:errors path="firstName"/></font>
					<br><br>			
				</td>
				</tr>
			
				<tr>
					<td><label>Last name</label></td>	
					<td><form:input path="lastName" />
					<font color = "red"><form:errors path="lastName"/></font>
					<br><br>
				</td>
				</tr>
				
				<tr>
					<td><label>Email</label></td>
					<td><form:input path="email" />
					<font color = "red"><form:errors path="email"/></font>
					<br><br>
				</td>
				</tr>
				
				<tr>
					<td><label>Pesel</label></td>
					<td><form:input path="pesel" />
					<font color = "red"><form:errors path="pesel"/></font>
					<br><br>
				</td>		
				</tr>
				
				<tr>
					<td><label>Age</label></td>
					<td><form:input path="age" />
					<font color = "red"><form:errors path="age"/></font>
					<br><br>	
				</td>
				</tr>
				
				<tr>
					<td><label>City</label></td>
					<td><form:input path="city" />
					<font color = "red"><form:errors path="city"/></font>
					<br><br>	
				</td>
				</tr>
				
				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Save player" /></td>
				</tr>
			</tbody>
			
			
					 	
		</form:form>
	
		<br>
		<input type="button" value="back to players" onclick="window.location.href='playerList'; return false;" />
		
	
	</div>


</html>