<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Client Holdings</title>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	</head>
	<body>
		<table>
			<tr>
				<th>Symbol</th>
				<th>Amount</th>
				<!--<th>Account</th>-->
			</tr>
			<c:forEach var="item" items="${HoldingTable}" >
				<td>${item.stockSymbol}</td>
				<td>${item.amount}</td>
				<!--<td>${item.accountId}</td>-->
			</c:forEach>
		</table>
	</body>
</html>