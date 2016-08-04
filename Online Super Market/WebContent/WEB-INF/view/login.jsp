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
     <div id="header" class="well " style="background-color: #0059b3; color:white;font-size: 30px;padding-bottom: 1px;padding-top: 0px;width: 100%;height: 135px;">
     <table><tr><td><img src="images/icon.png" style="height: 143px;width: 165px;"/></td>
     <td style="width: 645px; "> 
      <label style="color:white;font-size: 30px;font-style: italic;">
      MK Groceries</label></td></tr>
      </table></div>
<div class="row" style="height: 270px;">
<div class="col-sm-6">
<div class="panel ">
   			   <div  class="embed-responsive embed-responsive-16by9">
          			<iframe height="400px" width="100%" src="imageScroll.html" style="width: 542px; height: 281px;name="iframe"></iframe>
   	</div>
  </div>
	</div>
<div class="col-sm-6">
<div class="panel panel-primary">
  <div class="panel-heading"  style="background-color: #0059b3;">Sign In</div>
 	<div class="panel-body" style=" padding-bottom: 0px;">
	<form:form method="POST" modelAttribute="user" action="checkUser.html">

  		<div class="form-group">
    		<form:label path="email">Email Id</form:label>
    		<form:input path="email" type="email" class="form-control "  placeholder="Enter your email id"/>
  		</div>
  		<div class="form-group">
    		<form:label path="password">Password</form:label>
    		<form:input path="password" type="password" class="form-control"  placeholder="Enter your passsword"/>
  		</div>
  		<center style="width: 269px; "><button type="submit" class="btn btn-info">Submit</button>
  		<button type="reset" class="btn btn-danger">reset</button></center>
  		<label style="margin-left: 300px;">New User?  <a  href="register.html">Sign Up</a></label><p></p>
  	
	</form:form>
	</div></div></div></div>
	<div>
	<div class="page-header"><h2>Products</h2></div>
	<table><tr><td><img src="images/products/amul.png" style=" margin-left: 10px;"/></td>
	<td><img src="images/products/dabur.png" style="margin-left: 50px;"/></td>
	<td><img src="images/products/dove.png" style="margin-left: 50px;"/></td>
	<td><img src="images/products/amul.png" style="margin-left: 50px;"/></td></tr></table>
	</div>
	
	     <div id="header" class="well " style="background-color: #0059b3; color:white;font-size: 30px; margin-top: 53px;">
     <table><tr><td></td>
     <td><label style="color:white;font-size: 15px; margin-left: 200px;">Copyright Â© 2011-2016 Mk Groceries Pvt Ltd</label></td><td><p></p></td>
     <td><p style="color:white;font-size: 12px; left: 121px;" class="glyphicon glyphicon-earphone"> 044-265 256</p><p></p>
     <p style="color:white;font-size: 12px; left: 121px;" class="glyphicon glyphicon-envelope"> onlinesupermarket@gmail.com</p></td></tr></table></div>
</body>
</html>