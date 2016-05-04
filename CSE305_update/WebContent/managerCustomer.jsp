<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Manage Customer</title>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<c:forEach var="item" items="${EmployeeTable}" >
				<td>${item.id}</td>
				<td>${item.ssn}</td>
				<td>${item.startDate}</td>
				<td>${item.email}</td>
				<td>${item.creditCard}</td>
				<td>${item.rating}</td>
				<td>${item.address}</td>
				<td>${item.zipCode}</td>
				<td>${item.telephone}</td>
			</c:forEach>
		</table>
	</body>
	<footer>
		<%@include file="managerFooter.jsp"%>
	</footer>
</html>