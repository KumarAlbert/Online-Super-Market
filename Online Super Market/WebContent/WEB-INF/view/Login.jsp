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
     <div id="header" class="jumbotron " style="background-color: #0059b3; color:white;font-size: 30px">
     <table><tr><td><img src="images/icon.png" width="100px" height="100px"/></td>
     <td><label style="color:white;font-size: 30px">Online Super Market</label></td></tr></table></div>
<div class="row">
<div class="col-sm-6">
<div class="panel panel-info">
   	<div class="panel-body">
   	</div>
  </div>
	</div>
<div class="col-sm-6">
<div class="panel panel-primary">
  <div class="panel-heading"  style="background-color: #0059b3;">Sign Up</div>
 	<div class="panel-body">
	<form:form method="POST" modelAttribute="user" action="checkUser.html">
	<div class="row">
	<div class="col-sm-6">
  		<div class="form-group">
    		<form:label path="email">Email Id</form:label>
    		<form:input path="email" type="text" class="form-control "  placeholder="Enter your email id"/>
  		</div>
  		<div class="form-group">
    		<form:label path="password">Password</form:label>
    		<form:input path="password" type="password" class="form-control"  placeholder="Enter your passsword"/>
  		</div>
  		<center style="width: 269px; "><button type="submit" class="btn btn-info">Submit</button>
  		<button type="reset" class="btn btn-danger">reset</button></center>
<a href="redirect.jsp">register page</a>  		</div></div>
	</form:form>
	</div></div></div>
</body>
</html>