<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@include file="managerHeader.jsp"%>
</head>
<body>
	<div id='testDiv'></div>
	<div id='stockDiv'>
		<table>
			<tr>
				<th>Symbol</th>
				<th>Name</th>
				<th>Type</th>
				<th>Price</th>
				<th>Last Updated</th>
			</tr>
			<c:forEach var="item" items="${sessionScope.ManagerStockTable}">
				<tr>
					<td>${item.symbol}</td>
					<td>${item.name}</td>
					<td>${item.type}</td>
					<td>${item.price}</td>
					<td>${item.date}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div id='countDiv' class='hidden-div'>
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
	
	document.getElementById('testDiv').write("This works!");
</script>
</html>