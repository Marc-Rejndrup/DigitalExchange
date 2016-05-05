<!DOCTYPE html>
<html lang="en">
	<head>
		<%@include file="employeeHeader.jsp"%>
		<title>View Employees</title>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	</head>
	<body>
		<h1>Employees:</h1>
		<div class="center"><table>
			<tr>
				<th>Name</th>
				<th>SSN</th>
				<th>ID</th>
				<th>Employed Since</th>
				<th>Telephone</th>
				<th>Address</th>
				<th>Zip Code</th>
			</tr>
			<c:forEach var="item" items="${sessionScope.EmployeeEmployeeTable}" >
				<tr>
					<td>${item.name}</td>
					<td>${item.ssn}</td>
					<td>${item.employeeId}</td>
					<td>${item.startDate}</td>
					<td>${item.telephone}</td>
					<td>${item.address}</td>
					<td>${item.zipCode}</td>
				</tr>
			</c:forEach>
		</table>
		</div>
				<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>	
		<script>
		$.ajax({
			type: "POST",
			url: "employeeEmployee",
			context: document.body
		});
		
	</script>
	</body>
</html>