<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
<head>
	<title>List Company</title>
	
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
			
			<!-- put new button: add customer -->
			
			<input type="button" value="Add Company" 
			onclick="window.location.href='showFormForAdd'; return false;" 
			class="add-button"/> 
			
			<table>
			   <tr>
			   	<th>Name</th>
			   	<th>Explanation</th>
			   	<th>Action</th>
			   </tr>
			   
			   <!-- loop over and print our customers -->
			   <c:forEach var="tempCompany" items="${companies }">
			   
			   <!-- contruct an "update" link with company id -->
			   <c:url var="updateLink" value="/company/showFormForUpdate" >
			   	<c:param name="companyId" value="${tempCompany.id }"/>
			   </c:url>
			   <!-- contruct an "delete" link with company id -->
			   <c:url var="deleteLink" value="/company/delete" >
			   	<c:param name="companyId" value="${tempCompany.id }"/>
			   </c:url>
			   
			   	 <tr>
			        <td>${tempCompany.name}</td>
			        <td>${tempCompany.explanation}</td>
			        <td>
			        		<a href="${updateLink }">Update</a>
			        		|
			        		<a href="${deleteLink }"
			        		 onclick="if(!(confirm('Are you sure want to delete this company'))) return false">Delete</a>
			        </td>
			  	 </tr>
			   </c:forEach>
			</table>
		</div>
	</div>
</body>
</html>