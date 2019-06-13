<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


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

</body>

	<div id="wrapper">
		<div id="header">
			<h2>ToM - Tournament of Poker</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Save place</h3>
		
		<form:form action="savePlace" modelAttribute="place" method="POST">
		
			<form:errors path="*" cssClass = "errorblock" element = "div" /> 
			<br><br>

			
			<tbody>
				<tr>
					<td><label>Name</label></td>
					
					<td>
					<form:input path="name" />
					<form:errors path="name" cssClass = "error" />
					<br>
					</td>
				</tr>
			
				<tr>
					<td><label>City</label></td>	
					<td>
					<form:input path="city" />
					<form:errors path="city" cssClass = "error" />
					<br>
					</td>
				</tr>
				
				<tr>
					<td><label>Description</label></td>
					<td>
					<form:input path="description" />
					<form:errors path="description" cssClass = "error" />
					<br><br>
					</td>
				</tr>

				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Save place" /></td>
				</tr>
			</tbody>
			
				 	
		</form:form>
	
		<br>
		<input type="button" value="back to places" onclick="window.location.href='placeList'; return false;" />
	
	</div>

</html>