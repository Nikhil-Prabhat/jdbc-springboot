<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DISPLAY</title>
</head>
<body>

	<h1>This is the display page</h1>

	${result}

	<form action="display">
		Click here to see the database: <input type="submit">

	</form>

	<table>


		<c:forEach items="${list }" var="item">
			<tr>
				<td><c:out value="${item.id }" /></td>
				<td><c:out value="${item.name }" /></td>
			</tr>

		</c:forEach>

	</table>


</body>
</html>