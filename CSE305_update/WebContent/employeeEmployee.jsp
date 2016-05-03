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
				<th>ID</th>
				<th>SSN</th>
				<th>StartDate</th>
				<th>Address</th>
				<th>ZipCode</th>
				<th>Telephone</th>
			</tr>
			<c:forEach var="item" items="${HoldingTable}" >
				<td>${item.id}</td>
				<td>${item.ssn}</td>
				<td>${item.startDate}</td>
				<td>${item.address}</td>
				<td>${item.zipCode}</td>
				<td>${item.telephone}</td>
			</c:forEach>
		</table>
	</body>
</html>