<!DOCTYPE html>
<html lang="en">
	<head>
		<title>View Employees</title>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	</head>
	<body>
		<table>
			<tr>
				<th>Name</th>
				<th>SSN</th>
				<th>ID</th>
				<th>Manager</th>
				<th>Employed Since</th>
				<th>Telephone</th>
				<th>Address</th>
				<th>Zip Code</th>
			</tr>
			<c:forEach var="item" items="${EmployeeEmployeeTable}" >
				<tr>
					<td>${item.name}</td>
					<td>${item.ssn}</td>
					<td>${item.employeeId}</td>
					<td>${item.manager}</td>
					<td>${item.startDate}</td>
					<td>${item.telephone}</td>
					<td>${item.address}</td>
					<td>${item.zipCode}</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>