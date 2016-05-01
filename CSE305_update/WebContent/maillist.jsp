<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<c:forEach var="type" items="${emaillist}">
	${type} 
</c:forEach>

<form name="myForm" action="FacultyInformation.jsp" method="post">
<input id="Button2" type="submit" value="Back" />
</form>