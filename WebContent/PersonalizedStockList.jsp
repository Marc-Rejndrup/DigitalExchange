<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

Stocks Table
<table>
<tr>
	<td>Symbol</td>
	<td>StockName</td>
	<td>StockType</td>
	<td>StockDate</td>
	<td>MarketPrice</td>
</tr>
<c:forEach var="type" items="${stockinfo}">
<tr>
    <td>${type.symbol}</td>
    <td>${type.stockName}</td>
    <td>${type.stockType}</td>
    <td>${type.stockDate}</td>
    <td>${type.marketPrice}</td>
</tr>
</c:forEach>
</table>
<form name="myForm" action="FacultyInformation.jsp" method="post">
<input id="Button2" type="submit" value="Back" />

</form>