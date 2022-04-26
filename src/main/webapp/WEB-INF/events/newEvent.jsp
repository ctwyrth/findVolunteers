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
	
	<!-- <link rel="stylesheet" type="text/css" href="/css/style.css"> -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	
	<!-- <script type="text/javascript" src="/js/script.js"></script> -->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>

<body>
	<div class="container-fluid">
		<div class="container mx-auto mt-4">
			<div class="row mx-auto" style="width: 85%;">
				<h1 class="display-4"> Post an Event:</h1>
				<form:form action="/events/new" modelAttribute="event" method="post" class="row border border-1 rounded bg-light g-3">
					<p class="my-1"><span class="text-danger">*</span><em> - indicates a required field</em></p>
					<h4>Event:</h4>
					<div class="col-12">
	    				<form:label path="title" class="form-label"><span class="text-danger">*</span>Title:</form:label>
	    				<form:input type="text" path="title" class="form-control" id="title" />
		  				<div><form:errors path="title" class="text-danger" style="font-size: .75rem;" /></div>
	  				</div>
	  				<div class="col-12">
	    				<form:label path="host" class="form-label"><span class="text-danger">*</span>Host/Organization:</form:label>
	    				<form:input type="text" path="host" class="form-control" id="host" />
		  				<div><form:errors path="host" class="text-danger" style="font-size: .75rem;" /></div>
	  				</div>
	  				<div class="col-12">
	  					<form:label path="description" class="form-label"><span class="text-danger">*</span>Description:</form:label>
	  					<form:textarea path="description" id="description" class="form-control"></form:textarea>
		  				<div><form:errors path="description" class="text-danger" style="font-size: .75rem;" /></div>
	  				</div>
	  				<div class="col-md-5">
	  					<form:label path="start" class="form-label"><span class="text-danger">*</span>Start Date/Time:</form:label>
	  					<form:input type="date" path="start" id="start" class="form-control" />
		  				<div><form:errors path="start" class="text-danger" style="font-size: .75rem;" /></div>
	  				</div>
	  				<div class="col-md-5">
	  					<form:label path="end" class="form-label"><span class="text-danger">*</span>Start Date/Time:</form:label>
	  					<form:input type="date" path="end" id="start" class="form-control" />
		  				<div><form:errors path="end" class="text-danger" style="font-size: .75rem;" /></div>
	  				</div>
	  				<div class="col-md-2">
	  					<form:label path="needed" class="form-label">Needed:</form:label>
	  					<form:input type="number" path="needed" id="needed" class="form-control" />
		  				<div><form:errors path="needed" class="text-danger" style="font-size: .75rem;" /></div>
	  				</div>
	  				<hr />
	  				<h4>Location:</h4>
	  				<div class="col-12">
	    				<form:label path="address" class="form-label">Address:</form:label>
	    				<form:input type="text" path="address" class="form-control" id="address" placeholder="1234 Main St" />
		  				<div><form:errors path="address" class="text-danger" style="font-size: .75rem;" /></div>
	  				</div>
	  				<div class="col-12">
	    				<form:label path="address2" class="form-label">Address 2:</form:label>
	    				<form:input type="text" path="address2" class="form-control" id="address2" placeholder="Apartment, studio, or floor" />
		  				<div><form:errors path="address2" class="text-danger" style="font-size: .75rem;" /></div>
	  				</div>
	  				<div class="col-md-6">
	    				<form:label path="city" class="form-label">City:</form:label>
	    				<form:input type="text" path="city" class="form-control" id="city" />
		  				<div><form:errors path="city" class="text-danger" style="font-size: .75rem;" /></div>
	  				</div>
	  				<div class="col-md-4">
	   					<form:label path="state" class="form-label">State:</form:label>
	    				<form:input type="text" path="state" class="form-control" id="state" />
					    <div><form:errors path="state" class="text-danger" style="font-size: .75rem;" /></div>
				    </div>
				    <div class="col-md-2">
	    				<form:label path="zipCode" class="form-label"><span class="text-danger">*</span>Zip:</form:label>
	    				<form:input type="text" path="zipCode" class="form-control" id="zipCode" />
		  				<div><form:errors path="zipCode" class="text-danger" style="font-size: .75rem;" /></div>
	  				</div>
	  				<hr />
	  				<h4>Contact Info:</h4>
	  				<div class="col-md-4">
	  					<form:label path="contactPhone" class="form-label">Phone Number:</form:label>
	  					<form:input type="tel" path="contactPhone" pattern="(?:\(\d{3}\)|\d{3})[- ]?\d{3}[- ]?\d{4}" placeholder="(310) 555-1212" class="form-control" />
		  				<div><form:errors path="contactPhone" class="text-danger" style="font-size: .75rem;" /></div>
	  				</div>
	  				<div class="col-md-4">
	  					<form:label path="contactEmail" class="form-label">Email:</form:label>
	  					<form:input type="text" path="contactEmail" class="form-control" />
		  				<div><form:errors path="contactEmail" class="text-danger" style="font-size: .75rem;" /></div>
	  				</div>
	  				<div class="col-md-4">
	  					<form:label path="contactTwitter" class="form-label">Twitter:</form:label>
	  					<form:input type="text" path="contactTwitter" class="form-control" />
		  				<div><form:errors path="contactTwitter" class="text-danger" style="font-size: .75rem;" /></div>
	  				</div>
	  				<div class="col-md-4">
	  					<form:label path="contactFacebook" class="form-label">Facebook:</form:label>
	  					<form:input type="text" path="contactFacebook" class="form-control" />
		  				<div><form:errors path="contactFacebook" class="text-danger" style="font-size: .75rem;" /></div>
	  				</div>
	  				<div class="col-md-4">
	  					<form:label path="contactInstagram" class="form-label">Instagram:</form:label>
	  					<form:input type="text" path="contactInstagram" class="form-control" />
		  				<div><form:errors path="contactInstagram" class="text-danger" style="font-size: .75rem;" /></div>
	  				</div>
	  				<%-- <div class="col-md-4">
	  					<form:label path="contactWhatsApp" class="form-label">WhatsApp:</form:label>
	  					<form:input type="text" path="contactWhatsApp" class="form-control" />
		  				<div><form:errors path="contactWhatsApp" /></div>
	  				</div> --%>
	  				<div class="mb-3 text-center">
		  				<input type="submit" value="Post Event" class="col-2 btn btn-sm btn-primary" />  				
	  				</div>
	  			</form:form>
	  		</div>
  		</div>
	</div>
	<br />
	<br />
	<br />
</body>
</html>