<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
<head>
	<title>List Destination</title>
	
	<!-- ref to css -->
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>

<body>
	<div id="wrapper" >
		<div id="header">
			<h2> Web Flying</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">
			<!-- add our html table here -->
			
			<!-- put new button: add Destination -->
			
			<input type="button" value="Add Destination" 
			onclick="window.location.href='showFormForAdd'; return false;" 
			class="add-button"/> 
			
			<table>
			   <tr>
			   	<th>Name</th>
			   	<th>Explanation</th>
			   	<th>Country</th>
			   	<th>City</th>
			   	<th>District</th>
			   	<th>Action</th>
			   </tr>
			   
			   <!-- loop over and print our customers -->
			   <c:forEach var="tempDestination" items="${destinations }">
			   
			   <!-- contruct an "update" link with company id -->
			   <c:url var="updateLink" value="/destination/showFormForUpdate" >
			   	<c:param name="destinationId" value="${tempDestination.id }"/>
			   </c:url>
			   <!-- contruct an "delete" link with destination id -->
			   <c:url var="deleteLink" value="/destination/delete" >
			   	<c:param name="destinationId" value="${tempDestination.id }"/>
			   </c:url>
			   
			   	 <tr>
			        <td>${tempDestination.name}</td>
			        <td>${tempDestination.explanation}</td>
			        <td>${tempDestination.country}</td>
			        <td>${tempDestination.city}</td>
			        <td>${tempDestination.district}</td>
			        <td>
			        		<a href="${updateLink }">Update</a>
			        		|
			        		<a href="${deleteLink }"
			        		 onclick="if(!(confirm('Are you sure want to delete this destination'))) return false">Delete</a>
			        </td>
			  	 </tr>
			   </c:forEach>
			</table>
		</div>
	</div>
</body>
</html>