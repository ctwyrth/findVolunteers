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

<title>findVolunteers - Update Profile</title>

<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css">

<script type="text/javascript" src="/js/script.js"></script>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/c45b326a96.js"
	crossorigin="anonymous"></script>
</head>

<body>
	<main>
		<div
			class="d-flex flex-column flex-shrink-0 p-4 text-white bg-pumpkin"
			style="width: 220px;">
			<a href="/"
				class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none"><span
				class="fs-4">findVolunteers</span></a>
			<hr>
			<ul class="nav nav-pills flex-column mb-auto">
				<li class="nav-item"><a href="/" class="nav-link text-white"
					aria-current="page"><i class="fa-solid fa-house me-2"></i>Home</a>
				</li>
				<c:if test="${user != null}">
					<li><a href="/dashboard" class="nav-link text-white"><i
							class="fa-solid fa-gauge me-2"></i>Dashboard</a></li>
				</c:if>
				<li><a href="/about" class="nav-link text-white"><i
						class="fa-solid fa-circle-user me-2"></i>About</a></li>
				<li><a href="/contact" class="nav-link text-white"><i
						class="fa-solid fa-envelope me-2"></i>Contact</a></li>
				<li><a href="/allEvents" class="nav-link active"><i
						class="fa-solid fa-calendar me-2"></i>Events</a></li>
			</ul>
			<hr>
			<c:choose>
				<c:when test="${user == null}">
					<div class="btn-group-vertical" role="group">
						<button type="button" class="btn btn-sm btn-offpumpkin"
							data-bs-toggle="modal" data-bs-target="#registerModal">Register</button>
						<button type="button" class="btn btn-sm btn-moss"
							data-bs-toggle="modal" data-bs-target="#loginModal">Login</button>
					</div>
				</c:when>
				<c:otherwise>
					<div class="text-center mb-3">
						Welcome,
						<c:out value="${user.firstName}" />
						!
					</div>
					<div class="btn-group-vertical" role="group">
						<button class="btn btn-sm btn-moss" onclick="goProfile()">Profile</button>
						<button class="btn btn-sm btn-danger" onclick="goLogOut()">Sign
							Out</button>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="container-fluid" style="overflow-y: hidden;">
			<div class="row mx-auto mt-4" style="width: 90%;">
				<div class="shadow p-3 mb-5 bg-body rounded">
					<h1>Event</h1>
					<p>
						<strong class="">title</strong>
						<c:out value="${event.title}" />
					</p>
					<p>
						<strong>Host/Organization</strong>
						<c:out value="${event.host}" />
					</p>
					<p>
						<strong>Description </strong>
						<c:out value="${event.description}" />
					</p>
					<p class="mb-3">
						<strong>Start Date/Time </strong>
						<c:out value="${event.start}" />
					</p>
					<p class="mb-3">
						<strong>End Date/Time </strong>
						<c:out value="${event.end}" />
					</p>
					<hr />
						<h1>Location:</h1>
					<p class="mb-3">
						<strong>Address</strong>
						<c:out value="${event.address}" />
					</p>
					<p class="mb-3">
						<strong>Address 2</strong>
						<c:out value="${event.address2}" />
					</p>
					<p class="mb-3">
						<strong>City</strong>
						<c:out value="${event.city}" />
					</p>
					<p class="mb-3">
						<strong>State</strong>
						<c:out value="${event.state}" />
					</p>
					<p class="mb-3">
						<strong>Zip</strong>
						<c:out value="${event.zipCode}" />
					</p>
				</div>
			</div>
		</div>
	</main>
</body>
</html>