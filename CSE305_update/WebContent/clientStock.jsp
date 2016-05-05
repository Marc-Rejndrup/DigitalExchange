<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="clientHeader.jsp"%>
<title>Client Holdings</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
	<h1>Stocks</h1>


	<div class="center" id='stockDiv'>
		<div>
			<form action="clientStock" method="get">
				<div>
					Stock Symbol: <input type=text name="stockSymbol" />
				</div>
				<input type="submit" />
			</form>
		</div>
		<table>
			<tr>
				<th>Symbol</th>
				<th>Price</th>
				<th>Date</th>
			</tr>
			<c:forEach var="item" items="${sessionScope.ClientStockHistoryTable}">
				<tr>
					<td>${item.symbol}</td>
					<td>${item.price}</td>
					<td>${item.date}</td>
				</tr>
			</c:forEach>
		</table>
		
		<div>
			<form action="clientStock" method="get">
                    	<div>Stock Type: <input type=text name="stockType" /></div>
                    	<input type="submit" />
			</form>
		</div>
		<div>
		<table>
			<tr>
				<th>Symbol</th>
				<th>Name</th>
				<th>Type</th>
				<th>Price</th>
				<th>Last Updated</th>
			</tr>
			<c:forEach var="item" items="${sessionScope.ClientStockTypeTable}">
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
		<div>
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
				<c:forEach var="item" items="${sessionScope.ClientOrderTypeTable}">
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
		
		<div>
			<form action="clientStock" method="get">
                    	<div>Name Keyword: <input type=text name="keyword" /></div>
                    	<input type="submit" />
			</form>
		</div>
		
		<div>
		<table>
			<tr>
				<th>Symbol</th>
				<th>Name</th>
				<th>Type</th>
				<th>Price</th>
				<th>Last Updated</th>
			</tr>
			<c:forEach var="item" items="${sessionScope.ClientStockKeywordTable}">
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
		
		<div>
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
				<c:forEach var="item" items="${sessionScope.ClientOrderKeywordTable}">
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
		
	</div>

	<div id='countDiv' class='hidden-div'>
		<table>
			<tr>
				<th>Symbol</th>
				<th>Times Sold</th>
			</tr>
			<c:forEach var="item" items="${sessionScope.ClientStockBestTable}">
				<tr>
					<td>${item.stock}</td>
					<td>${item.count}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div id='typeDiv' class='hidden-div'>

	</div>

	<button id="buttonStock">Stock History Lookup</button>
	<button id="buttonCount">Best-Seller Stocks</button>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
	<script>
		$.ajax({
			type : "POST",
			url : "clientStock",
			context : document.body
		});

		var buttonStock = document.getElementById('buttonStock');
		var buttonCount = document.getElementById('buttonCount');
		var buttonType = document.getElementById('buttonType');

		buttonStock.onclick = function() {
			document.getElementById('stockDiv').style.display = 'block';
			document.getElementById('countDiv').style.display = 'none';
			document.getElementById('typeDiv').style.display = 'none';
		}

		buttonCount.onclick = function() {
			document.getElementById('stockDiv').style.display = 'none';
			document.getElementById('countDiv').style.display = 'block';
			document.getElementById('typeDiv').style.display = 'none';
		}

		buttonType.onclick = function() {
			document.getElementById('stockDiv').style.display = 'none';
			document.getElementById('countDiv').style.display = 'none';
			document.getElementById('typeDiv').style.display = 'block';
		}
	</script>
</body>
</html>