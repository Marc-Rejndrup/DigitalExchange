<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Client Orders</title>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	</head>
	<body>
		<table>
			<tr>
				<th>Stock</th>
				<th>Quantity</th>
				<th>Time</th>
				<th>Type</th>
				<th>Trailing</th>
				<th>Price</th>

			</tr>
			<c:forEach var="item" items="${HoldingTable}" >
				<td>${item.stockSymbol}</td>
				<td>${item.numShares}</td>
				<td>${item.dateTime}</td>
				<td>${item.orderType}</td>
				<c:if test="$item.OrderType == ts">
					<td></td><!-- more to add> -->
				</c:if>
				<td>${item.price}</td>
			</c:forEach>
		</table>
	</body>
</html>