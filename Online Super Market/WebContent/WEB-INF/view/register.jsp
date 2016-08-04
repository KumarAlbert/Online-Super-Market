<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<title>Create User</title>
</head>
<body>
     <div id="header" class="well " style="background-color: #0059b3; color:white;font-size: 30px;padding-bottom: 10px;padding-top: 9px;">
     <table><tr><td><img src="images/icon.png" width="100px" height="100px"/></td>
     <td><label style="color:white;font-size: 30px">Online Super Market</label></td></tr></table></div>
<div class="row">
<div class="col-sm-6">
<div class="panel panel-primary">
  <div class="panel-heading"  style="background-color: #0059b3;">Sign Up</div>
 	<div class="panel-body">
	<form:form method="POST" modelAttribute="user" action="saveUser.html">
	<div class="row">
	<div class="col-sm-6">
  		<div class="form-group">
    		<form:label path="firstName">First Name</form:label>
    		<form:input path="firstName" type="text" class="form-control "  placeholder="Enter your first name"/>
  		</div>
  		<div class="form-group">
    		<form:label path="email">Email</form:label>
    		<form:input path="email" type="email" class="form-control"  placeholder="Enter your email address"/>
  		</div>
  		<div class="form-group">
    		<form:label path="password">Password</form:label>
    		<form:input path="password" type="password" class="form-control"  placeholder="Enter your password"/>
  		</div>
  		</div>
  		<div class="col-sm-6">
 		<div class="form-group">
    		<form:label path="lastName">Last Name</form:label>
    		<form:input path="lastName" type="text" class="form-control"  placeholder="Enter your last name"/>
  		</div>
  		<div class="form-group">
    		<form:label path="mobileNumber">Mobile Number</form:label>
    		<form:input  path="mobileNumber"  type="integer" class="form-control" placeholder="Enter Mobile Number"/>
  		</div>
  		<div class="form-group">
    		<label>Confirm Password</label>
    		<input type="password" class="form-control" placeholder="Enter password again" />
  		</div>
  		</div>
  		<div class="form-group">
    		<form:label path="address" class="col-sm-3" style="border-left-width:20px">Address</form:label>
    		<form:input path="address" type="text" class="form-control" style=" width: 370px;    margin-left: 15px;" placeholder="Enter your address"/>
  		</div>
  		<button  style="margin-left: 130px;" type="submit" class="btn btn-info">Submit</button>  
  		<button type="reset" class="btn btn-danger">reset</button>
  		<label style="margin-left: 300px;">Already User?  <a  href="login.html">Sign In</a></label>
  		</div>
	</form:form>
	</div></div></div>
	<div class="col-sm-6">
<div class="panel panel-primary">
   	<div class="panel-body" style=" margin-bottom: 55px;">
   	<table><tr><b>Why us?</b>
   	<p>Register with our Online Super Market and
   	 it's quick and easy to add items to your 
   	 basket and head to the checkout to complete
   	  your first online order. </p></tr>
   	   <tr><b>Special Offers</b><p>
   	   The same offers are available online as 
   	   they are in store, plus there are online 
   	   exclusives. The prices we charge are the
   	    same low prices you will find in your 
   	    local store.</p></tr>
   	    <tr><b>ON Time Delivery</b><p>
   	    We deliver 6 days a week and if you 
   	    forget something you can always change
   	     your order to add. Our helpful 
   	     professionals will deliver straight
   	      to your door.</p></tr>
   	      <tr><b>Secure Payment</b><p>
   	   We accept all international and Indian
   	    credit card, debit cards. You can also
   	     pay via your Net banking facility. </p></tr></table></div>
  </div>
	</div></div>
	 <div id="header" class="well " style="background-color: #0059b3; color:white;font-size: 30px; margin-top: 53px;">
     <table><tr><td></td>
     <td><label style="color:white;font-size: 15px; margin-left: 200px;">Copyright Â© 2011-2016 Mk Groceries Pvt Ltd</label></td><td><p></p></td>
     <td><p style="color:white;font-size: 12px; left: 121px;" class="glyphicon glyphicon-earphone"> 044-265 256</p><p></p>
     <p style="color:white;font-size: 12px; left: 121px;" class="glyphicon glyphicon-envelope"> onlinesupermarket@gmail.com</p></td></tr></table></div>
</body>
</html>