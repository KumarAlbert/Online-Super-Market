<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
<div class="alert">
  <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> 
  <strong>Note!</strong>  Check Product details before adding new product to the Subcategory.
</div>
<div class="col-sm-6">
<div class="panel">
  <h2>ADD PRODUCT</h2>
	<form method="POST" action="productInsert.html">
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
	</form>
	</div></div>
	<div class="col-sm-6">
<div class="panel">
  <h2>Product Details</h2>
        <div>
          <table class="table table-striped" bgcolor="black" width="100%">
          <thead>
            <tr style="color: black;text-align: center;" height="40px">
                <td><dt>Product Name</dt></td>
                <td><dt>SubCategory Name</dt></td>              
            </tr>
          </thead>
          <c:forEach items="${product}" var="product">
          <tbody>
            <tr style="background-color:white;color: black;text-align: center;" height="50px" >
                <td><c:out value="${product.name}"/></td>
                <td><c:out value="${product.subcategory.name}"/></td>                              
            </tr>
          </tbody>
        </c:forEach>
        </table>
        <br>
        </div>
	</div></div>
</body>
</html>

