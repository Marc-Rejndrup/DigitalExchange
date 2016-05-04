<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Manage Customer</title>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<%@include file="managerHeader.jsp"%>
	</head>
	<body>
		<table>
			<tr>
				<th>Name</th>
				<th>ID</th>
				<th>SSN</th>
				<th>Email</th>
				<th>CreditCard</th>
				<th>Rating</th>
				<th>Address</th>
				<th>ZipCode</th>
				<th>Telephone</th>
			</tr>
			<c:forEach var="item" items="${sessionScope.ManagerClientTable}" >
			<tr>
				<td>${item.custNum}</td>
				<td>${item.name}</td>
				<td>${item.ssn}</td>
				<td>${item.email}</td>
				<td>${item.creditCard}</td>
				<td>${item.rating}</td>
				<td>${item.address}</td>
				<td>${item.zipCode}</td>
				<td>${item.telephone}</td>
				</tr>
			</c:forEach>
		</table>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>	
	</body>
		
	<footer>
	</footer>
	<script>
	$(function(){
		$.ajax({
			type: "POST",
			url: "managerClient",
			context: document.body
		});
	});
	

	</script>
</html>