<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

Order Table
<table>
<tr>
	<td>Id</td>
	<td>ClientId</td>
	<td>Date</td>
	<td>Stock</td>
	<td>PPS</td>
	<td>Order Type</td>
	<td>Price Type</td>
	<td>Percentage</td>
	<td># Shares</td>
</tr>
<c:forEach var="type" items="${orderinfo}">
<tr>
    <td>${type.id}</td>
    <td>${type.accountId}</td>
    <td>${type.dateTime}</td>
    <td>${type.stock}</td>
    <td>${type.pricePerShare}</td>
    <td>${type.orderType}</td>
    <td>${type.price}</td>
    <td>${type.percentage}</td>
    <td>${type.numShares}</td>
</tr>
</c:forEach>
</table>
<form name="myForm" action="FacultyInformation.jsp" method="post">
<input id="Button2" type="submit" value="Back" />

</form>