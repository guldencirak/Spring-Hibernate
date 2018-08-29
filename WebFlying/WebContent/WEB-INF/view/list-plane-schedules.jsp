<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
<head>
	<title>List Plane Schedule</title>
	
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
			
			<input type="button" value="Add Plane" 
			onclick="window.location.href='showFormForAdd'; return false;" 
			class="add-button"/> 
			
			<table>
			   <tr>
			   	<th>Code</th>
			   	<th>Explanation</th>
			   	<th>Action</th>
			   </tr>
			   
			   <!-- loop over and print our passengers -->
			   <c:forEach var="tempPlaneSchedule" items="${planeSchedules }">
			   
			   <!-- contruct an "update" link with plane id -->
			   <c:url var="updateLink" value="/planeSchedule/showFormForUpdate" >
			   	<c:param name="planeScheduleId" value="${tempPlaneSchedule.id }"/>
			   </c:url>
			   <!-- contruct an "delete" link with plane id -->
			   <c:url var="deleteLink" value="/planeSchedule/delete" >
			   	<c:param name="planeScheduleId" value="${tempPlaneSchedule.id }"/>
			   </c:url>
			   
			   	 <tr>
			        <td>${tempPlaneSchedule.code}</td>
			        <td>${tempPlaneSchedule.explanation}</td>
			        <td>
			        		<a href="${updateLink }">Update</a>
			        		|
			        		<a href="${deleteLink }"
			        		 onclick="if(!(confirm('Are you sure want to delete this PlaneSchedule'))) return false">Delete</a>
			        </td>
			  	 </tr>
			   </c:forEach>
			</table>
		</div>
	</div>
</body>
</html>