<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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

</body>


	<div id="wrapper">
		<div id="header">
			<h2>ToM - Tournament of Poker</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Save player</h3>
		
		<form:form action="updatePlayer" modelAttribute="player" method="POST">
		
		
			<form:errors path="*" cssClass = "errorblock" element = "div" /> 
			<br><br>
			
			
			<!-- need to associate this data with customer id-->
			<form:hidden path="id" />
			<tbody>
				<tr>
					<td><label>First name</label></td>
					<td>
						<form:input path="firstName" />
						<form:errors path="firstName" cssClass = "error" />
						<br><br>
					</td>
				</tr>
			
				<tr>
					<td><label>Last name</label></td>	
					<td>
						<form:input path="lastName" />
						<form:errors path="lastName"  cssClass = "error" />
						<br><br>
					</td>
				</tr>
				
				<tr>
					<td><label>Email</label></td>
					<td>
						<form:input path="email" />
						<form:errors path="email"  cssClass = "error" />
						<br><br>
					</td>
				</tr>
				
				<tr>
					<td><label>Pesel</label></td>
					<td>
						<form:input path="pesel" />
						<form:errors path="pesel"  cssClass = "error" />
						<br><br>
					</td>
				</tr>
				
				<tr>
					<td><label>Age</label></td>
					<td>
						<form:input path="age" />
						<form:errors path="age"  cssClass = "error" />
						<br><br>
					</td>
				</tr>
				
				<tr>
					<td><label>City</label></td>
					<td>
						<form:input path="city" />
						<form:errors path="city"  cssClass = "error" />
						<br><br>
					</td>
				</tr>
				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Update player" /></td>
				</tr>
			</tbody>
					 	
		</form:form>
	
		<br>
		<input type="button" value="back to players" onclick="window.location.href='playerList'; return false;" />
			
	</div>

</html>