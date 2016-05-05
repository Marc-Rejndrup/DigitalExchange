<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Manage Employees</title>
		<%@include file="managerHeader.jsp"%>
	</head>
	<body>
		<h1>Employees</h1>
		<div class ="center"><table>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>SSN</th>
				<th>Hourly Pay</th>
				<th>Employed Since</th>
				<th>Telephone</th>
				<th>Address</th>
				<th>Zip Code</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach var="item" items="${sessionScope.ManagerEmployeeTable}">
			<form action="editemployee" method="post">
				<tr>
					<td>${item.employeeId}</td>
					<td><input name='name${item.ssn}' value='${item.name}' /></td>
					<td>${item.ssn}</td>
					<td><input name='hourlyRate${item.ssn}' value='${item.hourlyRate}' /></td>
					<td>${item.startDate}</td>
					<td><input name='telephone${item.ssn}' value='${item.telephone}' /></td>
					<td><input name='address${item.ssn}' value='${item.address}' /></td>
					<td><input name='zipCode${item.ssn}' value='${item.zipCode}' /></td>
					<td><input type='submit' name='act' value='${item.ssn}' /></td>
					<td><input type='submit' name='delete' value='${item.ssn}' /></td>
				</tr>
			</form>
			</c:forEach>
		</table></div>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>	
			<script>
		$.ajax({
			type: "POST",
			url: "managerEmployee",
			context: document.body
		});
		
	</script>
	</body>
		
	<footer>
	</footer>

</html>