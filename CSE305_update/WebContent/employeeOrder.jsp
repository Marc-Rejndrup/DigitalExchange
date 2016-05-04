<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	</head>
	<body>
	<h3>Employees</h3>
		<table>
			<tr>
				<td>ID</td>
				<td>Account ID</td>
				<td>Stock</td>
				<td>${item.numShares}</td>
				<td>${item.dateTime}</td>
				<td>${item.orderType}</td>
				<td>${item.orderType}</td>
				<td>${item.orderType}</td>
			</tr>
			<c:forEach var="item" items="${EmployeeOrderTable}" >
				<tr>
					<td>${item.id}</td>
					<td>${item.accountId}</td>
					<td>${item.stock}</td>
					<td>${item.numShares}</td>
					<td>${item.dateTime}</td>
					<td>${item.orderType}</td>
					<c:choose>
						<c:when test="${item.orderType = a}">
							<td>${item.percentage}</td>
						</c:when>
						<c:when test="${item.orderType = a}">
							<td>${item.pricePerShare}</td>
						</c:when>
						<c:otherwise>
							<td></td>
						</c:otherwise>
					</c:choose>
					<td>${item.price}</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>