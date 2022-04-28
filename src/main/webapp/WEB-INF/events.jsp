<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>findVolunteers - All Events</title>

<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css">

<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/script.js"></script>
</head>

<body>
	<main>
		<div
			class="d-flex flex-column flex-shrink-0 p-4 text-white bg-pumpkin vh-100"
			style="width: 220px;">
			<a href="/"
				class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none"><span
				class="fs-4">findVolunteers</span></a>
			<hr>
			<ul class="nav nav-pills flex-column mb-auto">
				<li class="nav-item"><a href="/" class="nav-link text-white"><i
						class="fa-solid fa-house me-2"></i>Home</a></li>
				<c:if test="${user != null}">
					<li><a href="/dashboard" class="nav-link text-white"><i
							class="fa-solid fa-gauge me-2"></i>Dashboard</a></li>
				</c:if>
				<li><a href="/about" class="nav-link text-white"><i
						class="fa-solid fa-circle-user me-2"></i>About</a></li>
				<li><a href="/contact" class="nav-link text-white"><i
						class="fa-solid fa-envelope me-2"></i>Contact</a></li>
				<li><a href="/allEvents" class="nav-link active"
					aria-current="page"><i class="fa-solid fa-calendar me-2"></i>Events</a>
				</li>
			</ul>
			<hr>
			<c:choose>
				<c:when test="${!user}">
					<div class="btn-group" role="group">
						<button type="button" class="btn btn-sm btn-offpumpkin"
							data-bs-toggle="modal" data-bs-target="#registerModal">Register</button>
						<button type="button" class="btn btn-sm btn-moss"
							data-bs-toggle="modal" data-bs-target="#loginModal">Login</button>
					</div>
				</c:when>
				<c:otherwise>
					<div class="dropdown">
						<a href="#"
							class="d-flex align-items-center text-white text-decoration-none dropdown-toggle"
							id="dropdownUser1" data-bs-toggle="dropdown"
							aria-expanded="false"> <img src="https://github.com/mdo.png"
							alt="" width="32" height="32" class="rounded-circle me-2">
							<strong>mdo</strong>
						</a>
						<ul class="dropdown-menu dropdown-menu-dark text-small shadow"
							aria-labelledby="dropdownUser1">
							<li><a class="dropdown-item"
								href="/users/${user.id}/profile">Profile</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="/logout">Sign out</a></li>
						</ul>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="container-fluid" style="overflow-y: hidden;">
			<div class="row mx-auto mt-4" style="width: 90%;">
				<%-- <h1 class="display-4">Hello, <c:out value="${user.firstName}" /></h1> --%>
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
								<td><fmt:formatDate pattern="MMMM dd, yyyy"
										value="${event.start}" /></td>
								<td><fmt:formatDate pattern="MMMM dd, yyyy"
										value="${event.end}" /></td>
								<td><c:out value="${event.zipCode}" /></td>
								<td><c:out value="${event.contactPhone}" /></td>
								<td><c:out value="${event.contactEmail}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div style="overflow-x: hidden;">
				<div class="card mb-3 p-0" style="max-width: 100%;">
					<div class="row g-0">
						<div class="col-md-4">
							<img src="/img/landscape-volunteers.jpg"
								class="img-fluid rounded-start" alt="...">
						</div>
						<div class="col-md-8">
							<div class="card-body">
								<h5 class="card-title">Title</h5>
								<h6>Date</h6>
								<p class="card-text">Description.</p>
								<button class="d-flex justify-content-end btn btn-info">Show
									Event</button>
							</div>
						</div>
					</div>
				</div>
				<div class="card mb-3 p-0" style="max-width: 100%;">
					<div class="row g-0">
						<div class="col-md-4">
							<img src="/img/landscape-volunteers.jpg"
								class="img-fluid rounded-start" alt="...">
						</div>
						<div class="col-md-8">
							<div class="card-body">
								<h5 class="card-title">Title</h5>
								<h6>Date</h6>
								<p class="card-text">Description.</p>
								<button class="d-flex justify-content-end btn btn-info">Show
									Event</button>
							</div>
						</div>
					</div>
				</div>
			</div>

			</div>
		</div>
	</main>


</body>
</html>