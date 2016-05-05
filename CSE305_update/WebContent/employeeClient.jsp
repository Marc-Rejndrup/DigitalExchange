<html>
<head>
<%@include file="employeeHeader.jsp"%>
<title>View Clients</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
	<h1>Clients:</h1>
	<div class="center">
		<table>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>SSN</th>
				<th>Email</th>
				<th>CreditCard</th>
				<th>Rating</th>
				<th>Address</th>
				<th>ZipCode</th>
				<th>Telephone</th>
				<th>Edit</th>
			</tr>
			<c:forEach var="item" items="${sessionScope.EmployeeClientTable}">
				<tr>
					<form action="employeeClient" method="get">
					<td>${item.custNum}</td>
					<td><input name='name${item.ssn}' value='${item.name}' /></td>
					<td>${item.ssn}</td>
					<td><input name='email${item.ssn}' value='${item.email}' /></td>
					<td><input name='creditCard${item.ssn}'
						value='${item.creditCard}' /></td>
					<td><input name='rating${item.ssn}' value='${item.rating}' /></td>
					<td><input name='address${item.ssn}' value='${item.address}' /></td>
					<td><input name='zipCode${item.ssn}' value='${item.zipCode}' /></td>
					<td><input name='telephone${item.ssn}'
						value='${item.telephone}' /></td>
					<td><input type='submit' name='edit' value='${item.ssn}' /></td>
					</form>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div>
		<form action="generateemail" method="get">
			<input type="submit" value="Generate Mailing List">
		</form>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
	<script>
		$.ajax({
			type : "POST",
			url : "employeeClient",
			context : document.body
		});
	</script>
</body>
</html>