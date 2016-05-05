<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Stock History</title>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<style type="text/css">h1{text-align: center;}</style>
	</head>
	<body>
		<c:if test="${Order} == null">
			<h1>Stock History</h1>
		</c:if>
		<c:if test="${Order} != null">
			<h1>Order History</h1>
			Order information:
			<div class="center"><table>
				<tr>
					<th>Type</th>
					<th>Number of Shares</th>
					<th>Date</th>
					<th>Fee</th>
					<th>Symbol</th>
					<c:if test="${order.percentage == null && order.pricePerShare != null}">
						<th>Price Per Share</th>
					</c:if>
					<c:if test="${order.percentage != null && order.pricePerShare == null}">
						<th>Percentage</th>
					</c:if>
					<th>Price</th>
				</tr>
				<tr>
					<td>${order.orderType}</td>
					<td>${order.numShares}</td>
					<td>${order.dateTime}</td>
					<td>${order.fee}</td>
					<td>${order.stock}</td>
					<c:if test="${order.percentage == null && order.pricePerShare != null}">
						<td>${order.pricePerShare}</td>
					</c:if>
					<c:if test="${order.percentage != null && order.pricePerShare == null}">
						<td>${order.percentage}</td>
					</c:if>
					<td>${order.price}</td>
				</tr>
			</table></div>
		</c:if>
		<div class="center"><table>
			<tr>
				<th>Date</th>
				<th>Price</th>
			</tr>
			<c:forEach var="item" items="${ClientHistoryTable}" >
				<tr>
					<td>${item.date}</td>
					<td>${item.price}</td>
				<tr>
			</c:forEach>
		</table></div>
	</body>
</html>