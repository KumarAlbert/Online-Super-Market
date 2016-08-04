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
<title>Product</title>
</head>
<body>
<div class="row">
<div class="col-sm-12">
<div class="panel panel-primary">
  <div class="panel-heading">ADD PRODUCT</div>
 	<div class="panel-body">
	<form method="POST" action="productInsert.html">
	<div class="col-sm-6">
  		<div class="form-group">
    		<label >Enter SubCategory Name</label>
    		<input name="subcategoryName" type="text" class="form-control" required="required" pattern="[a-zA-Z& ]*" placeholder="SubCategory name" id="subcategoryName"/>
  		</div>
  		<div class="form-group">
    		<label >Enter Product Name</label>
    		<input name="productName" type="text" class="form-control" required="required" pattern="[a-zA-Z& ]*" placeholder="Enter product name" id="productName"/>
  		</div>
  		<div class="form-group">
    		<label >Enter Description</label>
    		<input name="description" type="text" class="form-control" required="required"  placeholder="Enter Description" id="description"/>
  		</div>
  		<div class="form-group">
    		<label >Enter ImageUrl</label>
    		<input name="imageurl" type="text" class="form-control" required="required"  placeholder="Enter url of image" id="imageurl"/>
  		</div>
  		<div class="form-group">
    		<label >Enter Available stock</label>
    		<input name="stock" type="text" class="form-control" required="required" pattern="^\d*" placeholder="Enter stock" id="stock"/>
  		</div>
  		<div class="form-group">
    		<label >Enter Unit Price</label>
    		<input name="price" type="integer" class="form-control" required="required"  placeholder="Unit Price of Product" id="price"/>
  		</div>
  		<center><button type="submit" class="btn btn-info">Submit</button>
  		<button type="reset" class="btn btn-danger">Reset</button></center>
  		</div>
	</form>
	</div></div></div>
	</div>
</body>
</html>

