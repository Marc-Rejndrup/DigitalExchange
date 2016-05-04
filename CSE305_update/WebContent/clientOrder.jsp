<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Client Orders</title>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	</head>
	<body>
		<h1>Your Orders.</h1>
		<table>
			<tr>
				<th>ID</th>
				<th>Stock</th>
				<th>Buy or Sell</th>
				<th>Quantity</th>
				<th>Time</th>
				<th>Type</th>
				<th>Trailing</th>
				<th>Completed At</th>
			</tr>
			<c:forEach var="item" items="${HoldingTable}" >
				<tr>
					<td>${item.accountId }
					<td>${item.stock}</td>
					<td>${item.buySell}</td>
					<td>${item.numShares}</td>
					<td>${item.dateTime}</td>
					<td>${item.orderType}</td>
					<td>${empty item.percentage ? item.pricePerShare : item.percentage}</td>
					<td>${empty item.price ? "Not completed." : item.price}</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>