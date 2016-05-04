<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
		<%@include file="managerHeader.jsp"%>
</head>
	<body>
		<table>
			<tr>
				<th>Symbol</th>
				<th>Name</th>
				<th>Type</th>
				<th>Price</th>
				<th>Last Updated</th>
			</tr>
			<c:forEach var="item" items="${sessionScope.ManagerStockTable}" >
			<tr>
				<td>${item.symbol}</td>
				<td>${item.name}</td>
				<td>${item.type}</td>
				<td>${item.price}</td>
				<td>${item.date}</td>
				</tr>
			</c:forEach>
		</table>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>	
	</body>
		
	<footer>
	</footer>
	<script>
		$.ajax({
			type: "POST",
			url: "managerStock",
			context: document.body
		});
	

	</script>
</html>