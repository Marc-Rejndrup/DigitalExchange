<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Revenue By Cust. Num.</title>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	</head>
	<body>
		<table>
			<tr>
				<th>Symbol</th>
				<th>Revenue</th>
				<!--<th>Account</th>-->
			</tr>
			<c:forEach var="item" items="${RevenueCNTable}" >
			<tr>
				<td>${item.stockSymbol}</td>
				<td>${item.price}</td>
				<!--<td>${item.accountId}</td>-->
			</tr>
			</c:forEach>
		</table>
	</body>
</html>