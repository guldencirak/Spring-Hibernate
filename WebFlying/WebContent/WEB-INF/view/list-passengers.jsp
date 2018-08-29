<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
<head>
	<title>List Passenger</title>
	
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
			
			<!-- put new button: add company -->
			
			<input type="button" value="Add Passenger" 
			onclick="window.location.href='showFormForAdd'; return false;" 
			class="add-button"/> 
			
			<table>
			   <tr>
			   	<th>Name</th>
			   	<th>Surname</th>
			   	<th>BirthDate</th>
			   	<th>Action</th>
			   </tr>
			   
			   <!-- loop over and print our passengers -->
			   <c:forEach var="tempPassenger" items="${passengers }">
			   
			   <!-- contruct an "update" link with passenger id -->
			   <c:url var="updateLink" value="/passenger/showFormForUpdate" >
			   	<c:param name="passengerId" value="${tempPassenger.id }"/>
			   </c:url>
			   <!-- contruct an "delete" link with passenger id -->
			   <c:url var="deleteLink" value="/passenger/delete" >
			   	<c:param name="passengerId" value="${tempPassenger.id }"/>
			   </c:url>
			   
			   	 <tr>
			        <td>${tempPassenger.name}</td>
			        <td>${tempPassenger.surname}</td>
			        <td>${tempPassenger.birthDate}</td>
			        <td>
			        		<a href="${updateLink }">Update</a>
			        		|
			        		<a href="${deleteLink }"
			        		 onclick="if(!(confirm('Are you sure want to delete this passenger'))) return false">Delete</a>
			        </td>
			  	 </tr>
			   </c:forEach>
			</table>
		</div>
	</div>
</body>
</html>