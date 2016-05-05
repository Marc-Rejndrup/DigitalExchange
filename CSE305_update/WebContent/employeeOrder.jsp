<html>
	<head>
		<%@include file="employeeHeader.jsp"%>
		<title>View Orders</title>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	</head>
	<body>
	<h1>Orders</h1>
	<!-- 
		<div class="center"><table>
			<tr>

			</tr>
			<c:forEach var="item" items="${EmployeeOrderTable}" >
				<tr>

				</tr>
			</c:forEach>
		</table></div>
		-->
		<form action="createOrder" method="post">
			            Account Number: <input type=text name="accNum"/><br />
                    	Order Type: <input id="Radio1" name="orderType" value='buy' checked="checked" type="radio" />Buy<input id="Radio2" name="orderType" value='sell' type="radio" />Sell<br />
                    	Stock: <input type=text name="stockSymbol" /><br/>
                    	# Shares: <input type=text name="numShares" /><br/>
                    	Fee: <input type=text name="fee" /> <br />
                    	Price Type: <input name="priceType" value='M' checked="checked" type="radio" />Market
                    	<input name="priceType" value='C' type="radio" />Market on Close
                    	<input name="priceType" value='T' type="radio" />Trailing Stop
                    	<input name="priceType" value='H' type="radio" />Hidden Stop<br />
                    	Stop Price (only for hidden): <input type=text name="price" /><br/>
                    	Stop Percentage (only for trailing): <input type=text name="percent" /><br/>
                    	Filled Price (only for market): <input type=text name="filledPrice" /><br/>
                    	<input id="Button4" type="submit" />
		</form>
	</body>
</html>