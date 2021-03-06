<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<head>
	<title>Save Destination</title>
	
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
			<h2>Add/Update Destination</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Save Destination</h3>
		<form:form action="saveDestination" modelAttribute="destination" method="POST">
		
		<!-- need to associate this data with destination id -->
		<form:hidden path="id" />
		
		<table>
			<tbody>
				<tr>
				<td><label>Name:</label> </td>
				<td><form:input path="Name"/> </td>
				</tr>
				<tr>
				<td><label>Explanation:</label> </td>
				<td><form:input path="Explanation"/> </td>
				</tr>
				<tr>
				<td><label>Country:</label> </td>
				<td><form:input path="Country" /> </td>
				</tr> 
				<tr>
				<td><label>City:</label> </td>
				<td><form:input path="City" /> </td>
				</tr>
				<tr>
				<td><label>District:</label> </td>
				<td><form:input path="District" /> </td>
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
			<a href="${pageContext.request.contextPath}/destination/list">Back to List</a>
		</p>
	</div>
</body>
</html>