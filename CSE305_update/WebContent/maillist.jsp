<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

Order Table
		<div class = "center">
			<table>
				<tr>
					<th>Name</th>
					<th>Telephone</th>
					<th>Email</th>
				</tr>
				<c:forEach var="item" items="${emaillist}">
					<tr>
						<td>${item.name}</td>
						<td>${item.telephone}</td>
						<td>${item.email}</td>
					</tr>
				</c:forEach>
			</table>
		</div>

<form name="myForm" action="FacultyInformation.jsp" method="post">
<input id="Button2" type="submit" value="Back" />
</form>