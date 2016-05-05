<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Revenue</title>
<%@include file="managerHeader.jsp"%>
</head>
<body>

<div id="accountDiv">
	<table>
		<tr>
			<th>Account ID</th>
			<th>Revenue</th>
		</tr>
		<c:forEach var="item"
			items="${sessionScope.ManagerAccountRevenueTable}">
			<tr>
				<td>${item.accNum}</td>
				<td>${item.revenue}</td>
			</tr>
		</c:forEach>
	</table>
</div>

<div id="symbolDiv" class="hidden-div center">
	<table>
		<tr>
			<th>Stock Symbol</th>
			<th>Revenue</th>
		</tr>
		<c:forEach var="item"
			items="${sessionScope.ManagerSymbolRevenueTable}">
			<tr>
				<td>${item.symbol}</td>
				<td>${item.revenue}</td>
			</tr>
		</c:forEach>
	</table>
</div>

<div id="typeDiv" class="hidden-div center">
	<table>
		<tr>
			<th>Stock Type</th>
			<th>Revenue</th>
		</tr>
		<c:forEach var="item"
			items="${sessionScope.ManagerTypeRevenueTable}">
			<tr>
				<td>${item.type}</td>
				<td>${item.revenue}</td>
			</tr>
		</c:forEach>
	</table>
</div>

<button id="buttonAcc">Revenue by Account</button>
<button id="buttonSym">Revenue by Stock Symbol</button>
<button id="buttonType">Revenue by Stock Type</button>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
</body>

<footer> </footer>
<script>
	$.ajax({
		type : "POST",
		url : "managerRevenue",
		context : document.body
	});
	
	var buttonAcc = document.getElementById('buttonAcc');
	var buttonSym = document.getElementById('buttonSym');
	var buttonType = document.getElementById('buttonType');
	
	buttonAcc.onclick = function(){
		document.getElementById('accountDiv').style.display = 'block';
		document.getElementById('symbolDiv').style.display = 'none';
		document.getElementById('typeDiv').style.display = 'none';
	}
	
	buttonSym.onclick = function(){
		document.getElementById('accountDiv').style.display = 'none';
		document.getElementById('symbolDiv').style.display = 'block';
		document.getElementById('typeDiv').style.display = 'none';
	}
	
	buttonType.onclick = function(){
		document.getElementById('accountDiv').style.display = 'none';
		document.getElementById('symbolDiv').style.display = 'none';
		document.getElementById('typeDiv').style.display = 'block';
	}

	
</script>
</html>