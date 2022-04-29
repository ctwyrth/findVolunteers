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
<<<<<<< Updated upstream
	<div class="container-fluid">
		<div class="container mx-auto mt-4">
			<h1 class="display-3">Welcome!</h1>
			<a href="/register">Register</a>
=======
	<main>
		<div class="d-flex flex-column flex-shrink-0 p-4 text-white bg-pumpkin" style="width: 220px;">
			<a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none"><span class="fs-4">findVolunteers</span></a>
		    <hr>
		    <ul class="nav nav-pills flex-column mb-auto">
		    	<li class="nav-item">
		        	<a href="#" class="nav-link active" aria-current="page"><i class="fa-solid fa-house me-2"></i>Home</a>
		    	</li>
		    	<c:if test="${user != null}">
		    		<li>
		        		<a href="/dashboard" class="nav-link text-white"><i class="fa-solid fa-gauge me-2"></i>Dashboard</a>
		    		</li>
		    	</c:if>
		    	<li><a href="/about" class="nav-link text-white"><i class="fa-solid fa-circle-user me-2"></i>About</a>
		    	</li>
		    	<li>
		        	<a href="/contact" class="nav-link text-white"><i class="fa-solid fa-envelope me-2"></i>Contact</a>
		    	</li>
		    	<li>
		    		<a href="/allEvents" class="nav-link text-white"><i class="fa-solid fa-calendar me-2"></i>Events</a>
		    	</li>
		    </ul>
   			<hr>
   			<c:choose>
   				<c:when test="${user == null}">
				    <div class="btn-group-vertical" role="group">
						<button type="button" class="btn btn-sm btn-offpumpkin" data-bs-toggle="modal" data-bs-target="#registerModal">Register</button>
						<button type="button" class="btn btn-sm btn-moss" data-bs-toggle="modal" data-bs-target="#loginModal">Login</button>
		  			</div>
   				</c:when>
   				<c:otherwise>
   					<div class="text-center mb-3">Welcome, <c:out value="${user.firstName}" />!</div>
   					<div class="btn-group-vertical" role="group">
				    	<button class="btn btn-sm btn-moss" onclick="goProfile()">Profile</button>
				    	<button class="btn btn-sm btn-danger" onclick="goLogOut()">Sign Out</button>
				    </div>
   				</c:otherwise>
   			</c:choose>
  		</div>
 <!-- main body of page ---------------------------------------------------------------------- -->
		<div style="overflow-x: hidden;">
			<div class="row mx-auto mt-4" style="width: 90%;">
				<div class="card bg-dark text-white p-0" style="height: 360px; overflow-y: hidden;">
					<img src="/img/landscape.jpg" class="img-fluid" alt="..." >
					<div class="card-img-overlay p-4 mt-5">
						<h3 class="card-title"><em>Finding Fulfillment...</em></h3>
						<p class="card-text">Have some extra time on your hands? Looking to give back to your community but can't afford to donate money? Try your hand at volunteering! Local organizations are looking for help doing everything from food service to dog grooming, to home building.</p>
						<p class="card-text">And you could be the PERFECT fit for the job.</p>
					</div>
				</div>
				<div class="mt-4">
					<form action="/events/search" method="post" class="d-flex search mx-auto" style="max-width: 65%;">
						<input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
						<button class="btn btn-outline-dark" type="submit" id="location">Search</button>
					</form>
				</div>
				<p></p>
			</div>
			<div class="row mx-auto p-0" style="width: 90%">
				<c:forEach var="e" items="${events}">
					<div class="col-sm-4">
						<div class="card px-0 mb-5">
						  <img src="/img/landscape-soup-kitchen.jpg" class="card-img-top" alt="volunteers packing food into boxes">
						  <div class="card-body">
						    <h5 class="card-title"><c:out value="${e.title}" /></h5>
						    <p class="card-text"><c:out value="${e.description}" /></p>
						    <a href="/events/${e.id}" class="btn btn-primary">More</a>
						  </div>
						</div>
					</div>
				</c:forEach>
			</div>
>>>>>>> Stashed changes
		</div>
	</div>

</body>
</html>