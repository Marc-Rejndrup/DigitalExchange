<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Manage Employees</title>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	</head>
	<body>
		<table>
			<tr>
				<th>Name</th>
				<th>SSN</th>
				<th>ID</th>
				<th>Manager</th>
				<th>Hourly Pay</th>
				<th>Employed Since</th>
				<th>Telephone</th>
				<th>Address</th>
				<th>Zip Code</th>
			</tr>
			<c:forEach var="item" items="${sessionScope.ManagerEmployeeTable}">
				<tr>
					<td>${item.name}</td>
					<td>${item.ssn}</td>
					<td>${item.employeeId}</td>
					<td>${item.manager}</td>
					<td>${item.hourlyRate}</td>
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
		<%@include file="managerFooter.jsp"%>
	</footer>
	<script>
		$.ajax({
			type: "POST",
			url: "managerEmployee",
			context: document.body
		});
	</script>
</html>