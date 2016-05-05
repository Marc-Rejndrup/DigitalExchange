<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

Order Table
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
					<th>Percentage</th>
					<th>PPS</th>
					<th>Price</th>
				</tr>
				<c:forEach var="item" items="${ManagerOrderTable}">
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
<form name="myForm" action="managerOrder.jsp" method="post">
<input id="Button2" type="submit" value="Back" />

</form>