<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Stocks</title>
<%@include file="managerHeader.jsp"%>
</head>
<body>
	<div id='testDiv'></div>
	<div id='stockDiv' class="center">
		<table>
			<tr>
				<th>Symbol</th>
				<th>Name</th>
				<th>Type</th>
				<th>Price</th>
				<th>Last Updated</th>
				<th>Edit</th>
			</tr>
			<c:forEach var="item" items="${sessionScope.ManagerStockTable}">
				<form action="managerStock" method="get">
					<tr>
						<td>${item.symbol}</td>
						<td>${item.name}</td>
						<td>${item.type}</td>
						<td><input name='price${item.symbol}' value='${item.price}' /></td>
						<td>${item.date}</td>
						<td><input type='submit' name='edit' value='${item.symbol}' /></td>
					</tr>
				</form>
			</c:forEach>
		</table>
	</div>
	<div id='countDiv' class='hidden-div center'>
		<table>
			<tr>
				<th>Symbol</th>
				<th>Times Traded</th>
			</tr>
			<c:forEach var="item" items="${sessionScope.ManagerStockCountTable}">
				<tr>
					<td>${item.stock}</td>
					<td>${item.count}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<button id="buttonStock">Current Stock Prices</button>
	<button id="buttonCount">Most Actively Traded Stock</button>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
</body>

<footer> </footer>
<script>
	$.ajax({
		type : "POST",
		url : "managerStock",
		context : document.body
	});

	var buttonStock = document.getElementById('buttonStock');
	var buttonCount = document.getElementById('buttonCount');

	buttonStock.onclick = function() {
		document.getElementById('stockDiv').style.display = 'block';
		document.getElementById('countDiv').style.display = 'none';
	}

	buttonCount.onclick = function() {
		document.getElementById('stockDiv').style.display = 'none';
		document.getElementById('countDiv').style.display = 'block';
	}
	
</script>
</html>