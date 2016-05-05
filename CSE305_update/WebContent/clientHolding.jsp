<!DOCTYPE html>
<html lang="en">
	<head>
		<%@include file="clientHeader.jsp"%>
		<title>Client Holdings</title>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	</head>
	<body>
		<h1>Your holdings:</h1>
		<div class="center"><table>
			<tr>
				<th>Symbol</th>
				<th>Amount</th>
			</tr>
			<c:forEach var="item" items="${sessionScope.HoldingTable}" >
			<tr>
				<td>${item.symbol}</td>
				<td>${item.amount}</td>
			</tr>
			</c:forEach>
		</table></div>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>	
		<script>
		$.ajax({
			type: "POST",
			url: "clientHolding",
			context: document.body
		});
		
	</script>
	</body>
</html>