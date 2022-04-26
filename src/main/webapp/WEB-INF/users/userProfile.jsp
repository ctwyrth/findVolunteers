<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	
	<title>User Profile</title>
	
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
				<h1 class="display-4">Volunteer Contact Information</h1>
				<c:choose>
					<c:when test="${userProfile.id != null}"> 
						<form:form action="/userProfile/${userProfile.id}/edit" modelAttribute="userProfile" method="post" class="row border border-1 rounded bg-light g-3">
							<input type="hidden" name="_method" value="put">
					</c:when>
					<c:otherwise>					
						<form:form action="/userProfile/${user_id}" modelAttribute="userProfile" method="post" class="row border border-1 rounded bg-light g-3">
					</c:otherwise>
				</c:choose>
			
					<p class="my-1"> <em> Please note all fields below are optional:</em></p>
					<h4>Please note all fields below are optional:</h4>
					<div class="col-12">
	    				<form:label path="userAddress" class="form-label">Street Address:</form:label>
	    				<form:input type="text" path="userAddress" class="form-control" id="userAddress" />
		  				<div><form:errors path="userAddress" /></div>
	  				</div>
	  				<div class="col-12">
	    				<form:label path="userAddress2" class="form-label">Address Line 2(Apartment number, etc):</form:label>
	    				<form:input type="text" path="userAddress2" class="form-control" id="userAddress2" />
		  				<div><form:errors path="userAddress2" /></div>
	  				</div>
	  				<div class="col-12">
	  					<form:label path="userCity" class="form-label">City:</form:label>
	  					<form:input path="userCity" class="form-control" id="userCity"/>
		  				<div><form:errors path="userCity" /></div>
	  				</div>
	  				<div class="col-md-5">
	  					<form:label path="userState" class="form-label">State:</form:label>
	  					<form:select class="form-control" path="userState" id="userState">
							<form:option value="AK">Alaska</form:option>
							<form:option value="AL">Alabama</form:option>
							<form:option value="AR">Arkansas</form:option>
							<form:option value="AZ">Arizona</form:option>
							<form:option value="CA">California</form:option>
							<form:option value="CO">Colorado</form:option>
							<form:option value="CT">Connecticut</form:option>
							<form:option value="DC">District of Columbia</form:option>
							<form:option value="DE">Delaware</form:option>
							<form:option value="FL">Florida</form:option>
							<form:option value="GA">Georgia</form:option>
							<form:option value="HI">Hawaii</form:option>
							<form:option value="IA">Iowa</form:option>
							<form:option value="ID">Idaho</form:option>
							<form:option value="IL">Illinois</form:option>
							<form:option value="IN">Indiana</form:option>
							<form:option value="KS">Kansas</form:option>
							<form:option value="KY">Kentucky</form:option>
							<form:option value="LA">Louisiana</form:option>
							<form:option value="MA">Massachusetts</form:option>
							<form:option value="MD">Maryland</form:option>
							<form:option value="ME">Maine</form:option>
							<form:option value="MI">Michigan</form:option>
							<form:option value="MN">Minnesota</form:option>
							<form:option value="MO">Missouri</form:option>
							<form:option value="MS">Mississippi</form:option>
							<form:option value="MT">Montana</form:option>
							<form:option value="NC">North Carolina</form:option>
							<form:option value="ND">North Dakota</form:option>
							<form:option value="NE">Nebraska</form:option>
							<form:option value="NH">New Hampshire</form:option>
							<form:option value="NJ">New Jersey</form:option>
							<form:option value="NM">New Mexico</form:option>
							<form:option value="NV">Nevada</form:option>
							<form:option value="NY">New York</form:option>
							<form:option value="OH">Ohio</form:option>
							<form:option value="OK">Oklahoma</form:option>
							<form:option value="OR">Oregon</form:option>
							<form:option value="PA">Pennsylvania</form:option>
							<form:option value="PR">Puerto Rico</form:option>
							<form:option value="RI">Rhode Island</form:option>
							<form:option value="SC">South Carolina</form:option>
							<form:option value="SD">South Dakota</form:option>
							<form:option value="TN">Tennessee</form:option>
							<form:option value="TX">Texas</form:option>
							<form:option value="UT">Utah</form:option>
							<form:option value="VA">Virginia</form:option>
							<form:option value="VT">Vermont</form:option>
							<form:option value="WA">Washington</form:option>
							<form:option value="WI">Wisconsin</form:option>
							<form:option value="WV">West Virginia</form:option>
							<form:option value="WY">Wyoming</form:option>
						</form:select>
		  <!-- if we are limiting selection then there is no error unless we link with City
		  			<div><form:errors path="userState" /></div>
		   -->	
	  				</div>
	  				<div class="col-md-5">
	  					<form:label path="userZipCode" class="form-label">ZipCode:</form:label>
	  					<form:input type="number" path="userZipCode" id="start" class="form-control" />
		  				<div><form:errors path="userZipCode" /></div>
	  				</div>
	  				<div class="col-md-2">
	  					<form:label path="userPhone" class="form-label">Phone:</form:label>
	  					<form:input type="tel" path="userPhone" id="userPhone" pattern="(?:\(\d{3}\)|\d{3})[- ]?\d{3}[- ]?\d{4}" placeholder="(310) 555-1212" class="form-control" />
		  				<div><form:errors path="userPhone" /></div>
	  				</div>
	  				<hr />
	  				<h4>Social Media:</h4>
	  				<div class="col-12">
	    				<form:label path="userTwitter" class="form-label">Twitter @:</form:label>
	    				<form:input type="text" path="userTwitter" class="form-control" id="userTwitter"/>
		  				<div><form:errors path="userTwitter" /></div>
	  				</div>
	  				<div class="col-12">
	    				<form:label path="userFacebook" class="form-label">Facebook:</form:label>
	    				<form:input type="text" path="userFacebook" class="form-control" id="userFacebook"/>
		  				<div><form:errors path="userFacebook" /></div>
	  				</div>
	  				<div class="col-md-6">
	    				<form:label path="userInstagram" class="form-label">Instagram @:</form:label>
	    				<form:input type="text" path="userInstagram" class="form-control" id="userInstagram" />
		  				<div><form:errors path="userInstagram" /></div>
	  				</div>
	  				<hr />
	  		<!-- needs to be loggedin user -->
	  				<form:input type="hidden" path="user_id" value="${user_id}"/> 
	  				<div class="mb-3 text-center">
		  				<input type="submit" value="Update Information" class="col-2 btn btn-sm btn-primary" />  				
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