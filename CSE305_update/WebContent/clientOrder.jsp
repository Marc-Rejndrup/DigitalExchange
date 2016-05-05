<!DOCTYPE html>
<html lang="en">
	<head>
		<%@include file="clientHeader.jsp"%>
		<title>Client Orders</title>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	</head>
	<body>
		<h1>Orders Lookup:</h1>
		<div>
			<form action="clientOrder" method="post">
                    	<div>Account ID: <input type=text name="custNum" /></div>
                    	<input type="submit" />
			</form>
		</div>
		<div class = "center">
			<table>
				<tr>
					<th>Order ID</th>
					<th>Account Id</th>
					<th>Stock</th>
					<th>#</th>
					<th>Order Type</th>
					<th>Timestamp</th>
					<th>Fee</th>
					<th>Fulfilled Price</th>
				</tr>
				<c:forEach var="item" items="${sessionScope.ClientOrderTable}">
					<tr>
						<td>${item.id}</td>
						<td>${item.accountId}</td>
						<td>${item.stock}</td>
						<td>${item.numShares}</td>
						<td>${item.buySell}</td>
						<td>${item.dateTime}</td>
						<td>${item.fee}</td>
						<td>${item.price}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
				<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>	
		<script>
		
	</script>
	</body>
</html>