<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<head>
	<title>Save Plane</title>
	
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
			<h2>Add/Update Plane</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Save Add/Update Plane</h3>
		<form:form action="savePlane" modelAttribute="plane" method="POST">
		
		<!-- need to associate this data with plane id -->
		<form:hidden path="id" />
		
		<table>
			<tbody>
				<tr>
				<td><label>Code:</label> </td>
				<td><form:input path="Code"/> </td>
				</tr>
				<tr>
				<td><label>Explanation:</label> </td>
				<td><form:input path="Explanation"/> </td>
				</tr>
				
				<tr>
				<td><label>Company:</label> </td>
				<td>
				<form:select path="company">
  				 <form:option value="NONE" label="--- Select ---"/>
  				 <form:options items="${companies}" itemValue="id" itemLabel="name"/></td>
				</form:select> 
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
			<a href="${pageContext.request.contextPath}/plane/list">Back to List</a>
		</p>
	</div>
</body>
</html>