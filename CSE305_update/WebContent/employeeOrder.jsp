<html>
	<head>
		<%@include file="employeeHeader.jsp"%>
		<title>View Orders</title>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	</head>
	<body>
	<h1>Orders</h1>
		<div class="center"><table>
			<tr>
				<td>ID</td>
				<td>Account ID</td>
				<td>Stock</td>
				<td>${item.numShares}</td>
				<td>${item.dateTime}</td>
				<td>${item.orderType}</td>
				<td>${item.orderType}</td>
				<td>${item.orderType}</td>
			</tr>
			<c:forEach var="item" items="${EmployeeOrderTable}" >
				<tr>
					<td>${item.id}</td>
					<td>${item.accountId}</td>
					<td>${item.stock}</td>
					<td>${item.numShares}</td>
					<td>${item.dateTime}</td>
					<td>${item.orderType}</td>
					<c:choose>
						<c:when test="${item.orderType = a}">
							<td>${item.percentage}</td>
						</c:when>
						<c:when test="${item.orderType = a}">
							<td>${item.pricePerShare}</td>
						</c:when>
						<c:otherwise>
							<td></td>
						</c:otherwise>
					</c:choose>
					<td>${item.price}</td>
				</tr>
			</c:forEach>
		</table></div>
	</body>
</html>