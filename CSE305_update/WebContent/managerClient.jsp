<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Manage Clients</title>
		<%@include file="managerHeader.jsp"%>
	</head>
	<body>
		<h1>Client</h1>
		<div class ="center"><table>
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
		</table></div>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>	
	</body>
		
	<footer>
	</footer>
	<script>
		$.ajax({
			type: "POST",
			url: "managerClient",
			context: document.body
		});
	

	</script>
</html>