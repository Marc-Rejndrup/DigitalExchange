<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Orders</title>
<%@include file="managerHeader.jsp"%>
</head>
	<body>
	<h1>Orders</h1>
		<div>
			<form action="managerOrder" method="get">
                    	<div>Stock Symbol: <input type=text name="stockSymbol" /></div>
                    	<div>Customer Number: <input type=text name="custNum" /></div>
                    	<div>Month: <input type=text name="month" /> Year: <input type=text name="year" /></div>
                    	<input type="submit" />
			</form>
		</div>
		
		<div class = "center">
			<table>
				<tr>
					<th>ID</th>
					<th>Account Id</th>
					<th>Stock</th>
					<th>#</th>
					<th>Order Type</th>
					<th>Price Type</th>
					<th>Timestamp</th>
					<th>Fee</th>
					<th>Stop Percentage</th>
					<th>Stop Price</th>
					<th>Fulfilled Price</th>
				</tr>
				<c:forEach var="item" items="${sessionScope.ManagerOrderTable}">
					<tr>
						<td>${item.id}</td>
						<td>${item.accountId}</td>
						<td>${item.stock}</td>
						<td>${item.numShares}</td>
						<td>${item.buySell}</td>
						<td>${item.orderType}</td>
						<td>${item.dateTime}</td>
						<td>${item.fee}</td>
						<td>${item.percentage}</td>
						<td>${item.pricePerShare}</td>
						<td>${item.price}</td>
					</tr>
				</c:forEach>
			</table>
		</div>

		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>	
	</body>
		
	<footer>
	</footer>
	<script>
	</script>
</html>