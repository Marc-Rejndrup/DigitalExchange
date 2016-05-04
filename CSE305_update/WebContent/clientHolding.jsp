<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Client Holdings</title>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	</head>
	<body>
		<h1>Your holdings:</h1>
		<table>
			<tr>
				<th>Symbol</th>
				<th>Amount</th>
			</tr>
			<c:forEach var="item" items="${HoldingTable}" >
				<td>${item.stockSymbol}</td>
				<td>${item.amount}</td>
			</c:forEach>
		</table>
	</body>
</html>