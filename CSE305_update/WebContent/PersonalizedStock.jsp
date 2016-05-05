<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

Order Table
<div classs= "center">
<table>
<tr>
	<td>Symbol</td>
	<td>Name</td>
	<td>Type</td>
	<td>Price</td>
	<td>Date</td>
</tr>
<c:forEach var="type" items="${stockinfo}">
<tr>
    <td>${type.symbol}</td>
    <td>${type.name}</td>
    <td>${type.price}</td>
    <td>$(type.type)</td>
    <td>$(type.date)</td>
</tr>
</c:forEach>
</table>
</div>
<form name="myForm" action="FacultyInformation.jsp" method="post">
<input id="Button2" type="submit" value="Back" />

</form>