<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Revenue By Stock Type</title>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	</head>
	<body>
		<table>
			<tr>
				<th>Type</th>
				<th>Revenue</th>
				<!--<th>Account</th>-->
			</tr>
			<c:forEach var="item" items="${RevenueTypeTable}" >
				<td>${item.type}</td>
				<td>${item.price}</td>
				<!--<td>${item.accountId}</td>-->
			</c:forEach>
		</table>
	</body>
</html>