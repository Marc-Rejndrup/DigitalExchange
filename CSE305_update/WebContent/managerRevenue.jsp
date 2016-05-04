<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
		<%@include file="managerHeader.jsp"%>
</head>
	<body>
		<table>
			<tr>
				<th>Account ID</th>
				<th>Revenue</th>
			</tr>
			<c:forEach var="item" items="${sessionScope.ManagerRevenueTable}" >
			<tr>
				<td>${item.accNum}</td>
				<td>${item.revenue}</td>
				</tr>
			</c:forEach>
		</table>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>	
	</body>
		
	<footer>
	</footer>
	<script>
	$(function(){
		$.ajax({
			type: "POST",
			url: "managerRevenue",
			context: document.body
		});
	});
	

	</script>
</html>