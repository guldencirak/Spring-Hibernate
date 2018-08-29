<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<head>
	<title>Save Passenger</title>
	
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
		  
		  <link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
		  
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Add/Update Passenger</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Save Passenger</h3>
		<form:form action="savePassenger" modelAttribute="passenger" method="POST">
		
		<!-- need to associate this data with customer id -->
		<form:hidden path="id" />
		
		<table>
			<tbody>
				<tr>
				<td><label>Name:</label> </td>
				<td><form:input path="Name"/> </td>
				</tr>
				<tr>
				<td><label>Surname:</label> </td>
				<td><form:input path="Surname"/> </td>
				</tr>
				<tr>
				<td><label>Birthdate:</label> </td>
				<td><form:input path="BirthDate" type="date" /> </td>
				</tr> 
				<tr>
				<td><label></label> </td>
				<td><input type="submit" value="Save" class="save"/> </td>
				</tr>
			</tbody>
		</table>
		</form:form>
		
		<div style="clear; both;">
		</div>
		<p>
			<a href="${pageContext.request.contextPath}/passenger/list">Back to List</a>
		</p>
	</div>
</body>
</html>