<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Employees</title>
	</head>
	<body>
		<table>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>SSN</th>
				<th>Manager</th>
				<th>Employed Since</th>
				<th>Telephone</th>
				<th>Address</th>
				<th>Zip Code</th>
			</tr>
			<c:forEach var="item" items="${sessionScope.TheEmployeeTable}">
				<tr>
					<td>${item.employeeId}</td>
					<td>${item.name}</td>
					<td>${item.ssn}</td>
					<td>${item.manager}</td>
					<td>${item.startDate}</td>
					<td>${item.telephone}</td>
					<td>${item.address}</td>
					<td>${item.zipCode}</td>
				</tr>
			</c:forEach>
		</table>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>	
	</body>
		
	<footer>
	</footer>
	<script>
		$.ajax({
			type: "POST",
			url: "Employee",
			context: document.body
		});
	</script>
</html>