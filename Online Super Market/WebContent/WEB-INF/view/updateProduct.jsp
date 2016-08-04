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
  <div class="panel-heading">UPDATE PRODUCT</div>
 	<div class="panel-body">
	<form method="POST" action="productUpdate.html">
	<div class="row">
	<div class="col-sm-6">
  		<div class="form-group">
    		<label >Enter Product Name</label>
    		<input name="productName" type="text" class="form-control" pattern="[a-zA-Z& ]*" required="required" placeholder="Name of the Product"/>
  		</div>
  		<div class="form-group">
  	        <label>Select your choice to be updated</label>
                <select name="choice" style="margin-left: 22px; padding-left: 22px;">
                    <option value="name">Name</option>
                    <option value="description">Description</option>
                    <option value="imageUrl">ImageUrl</option>
                    <option value="stock">Stock</option>
                    <option value="price">Price</option>
                </select>
        </div> 
  		<div class="form-group">
    		<label>Enter value to be changed</label>
    		<input name="newValue" type="text" class="form-control" required="required" placeholder="Value to be updated"/>
  		</div>                       
  		<center><button type="submit" class="btn btn-info">Submit</button>
  		<button type="reset" class="btn btn-danger">Reset</button></center>
  		</div>
	</form>
	</div></div></div>
	</div>
</body>
</html>
