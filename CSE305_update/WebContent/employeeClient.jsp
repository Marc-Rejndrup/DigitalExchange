<html>
	<head>
		<%@include file="employeeHeader.jsp"%>
		<title>View Clients</title>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	</head>
	<body>
		<h1>Clients:</h1>
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
			<c:forEach var="item" items="${sessionScope.EmployeeClientTable}" >
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
		<script>
		$.ajax({
			type: "POST",
			url: "employeeClient",
			context: document.body
		});
		
	</script>
	</body>
</html>