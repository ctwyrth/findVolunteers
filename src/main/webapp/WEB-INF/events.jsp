<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	
	<title>Insert title here</title>
	
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	
	<script type="text/javascript" src="/js/script.js"></script>
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>

<body>
	<div class="container-fluid">
		<div class="container mx-auto mt-4">
			<h1 class="display-4">Hello, <c:out value="${user.firstName}" /></h1>
			<table class="table">
				<thead>
					<tr>
						<th>Title</th>
						<th>Host</th>
						<th>Start Date</th>
						<th>End Date</th>
						<th>Zip Code</th>
						<th>Contact Phone</th>
						<th>Contact Email</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="event" items="${events}">
						<tr>
							<td><c:out value="${event.title}" /></td>
							<td><c:out value="${event.host}" /></td>
							<td><fmt:formatDate pattern="MMMM dd, yyyy" value="${event.start}" /></td>
							<td><fmt:formatDate pattern="MMMM dd, yyyy" value="${event.end}" /></td>
							<td><c:out value="${event.zipCode}" /></td>
							<td><c:out value="${event.contactPhone}" /></td>
							<td><c:out value="${event.contactEmail}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div>
				<a href="/dashboard" class="btn btn-sm btn-primary">Dashboard</a>
			</div>
		</div>
	</div>

</body>
</html>