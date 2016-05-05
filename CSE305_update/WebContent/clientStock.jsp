<!DOCTYPE html>
<html lang="en">
	<head>
		<%@include file="clientHeader.jsp"%>
		<title>Client Holdings</title>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	</head>
	<body>
		<h1>Stocks</h1>
		<div>
			<form action="clientStock" method="post">
                    	<div>Stock Symbol: <input type=text name="stockSymbol" /></div>
                    	<input type="submit" />
			</form>
		</div>
		
		<div class="center"><table>
			<tr>
				<th>Symbol</th>
				<th>Price</th>
				<th>Date</th>
			</tr>
			<c:forEach var="item" items="${sessionScope.ClientStockHistoryTable}" >
			<tr>
				<td>${item.symbol}</td>
				<td>${item.price}</td>
				<td>${item.date}</td>
			</tr>
			</c:forEach>
		</table></div>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>	
		<script>
		/*$.ajax({
			type: "POST",
			url: "clientStock",
			context: document.body
		});*/
		
	</script>
	</body>
</html>