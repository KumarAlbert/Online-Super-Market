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
     <div id="header" class="jumbotron ">
     <label>Online Super Market</label></div>
<div class="row">
<div class="col-sm-12">
<div class="panel panel-primary">
  <div class="panel-heading">Sign Up</div>
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
    		<form:input  path="mobileNumber"  type="text" class="form-control"  placeholder="Enter your mobile number"/>
  		</div>
  		<div class="form-group">
    		<label>Confirm Password</label>
    		<input type="password" class="form-control" placeholder="Enter your confirm password" />
  		</div>
  		</div>
  		<div class="form-group">
    		<form:label path="address" class="col-sm-3" style="border-left-width:20px">Address</form:label>
    		<form:input path="address" type="text" class="form-control"  placeholder="Enter your address"/>
  		</div>
  		<center><button type="submit" class="btn btn-info">Submit</button>
  		<button type="reset" class="btn btn-danger">reset</button></center>
  		</div>
	</form:form>
	</div></div></div>
	</div>
</body>
</html>