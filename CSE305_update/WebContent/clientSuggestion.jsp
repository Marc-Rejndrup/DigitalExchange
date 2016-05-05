<html lang="en">
	<head>
		<%@include file="clientHeader.jsp"%>
		<title>Client Suggestions</title>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	</head>
	<body>
		<h1>Suggestions based on your holdings:</h1>
		<div class="center">
			<table>
				<tr>
					<th>Symbol</th>
					<th>Name</th>
					<th>Type</th>
					<th>Price</th>
					<th>Last Updated</th>
				</tr>
				<c:forEach var="item" items="${sessionScope.ClientSuggestionTable}">
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
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>	
		<script>
		$.ajax({
			type: "POST",
			url: "clientSuggestion",
			context: document.body
		});
		
	</script>
	</body>
</html>