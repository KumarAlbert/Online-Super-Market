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
<script>
function validation() {
    var productName = document.getElementById('productName').value;
    var subcategoryName = document.getElementById('subcategoryName').value;
    var stock = document.getElementById('stock').value;
    var price = document.getElementById('price').value;
	var stringForProduct = /^([a-zA-Z ]{2,30})$/ 
	var stringForSubCategory = /^([a-zA-Z&]{2,30})$/ ;
	var numberForPrice = /^(([0-9]{1,7}([.0-9]{3}))|([0-9]{1,7}))$/;
	var numberForStock = /^[0-9]{1,4}$/;
	if(stringForSubCategory.test(subcategoryName)) {
		if(stringForProduct.test(productName)) {
			if(numberForStock.test(stock)) {
				if(numberForPrice.test(price)){
					return true;
				} else {
					 alert("Enter valid price value!!");
			    	 return false;
				}
			} else {
				 alert("Enter valid stock value!!");
		    	 return false;
			}
		} else {
			 alert("Enter valid product name!!");
	    	 return false;
		}
	} else {
		 alert("Enter valid subcategory name!!");
    	 return false;
	}
}
</script>
</head>
<body>
<div class="alert">
  <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> 
  <strong>Note!</strong>  Check Product details before adding new product to the Subcategory.
</div>
<div class="col-sm-6">
<div class="panel">
  <h2>ADD PRODUCT</h2>
	<form onsubmit="return validation()" method="POST" action="productInsert.html">
  		<div class="form-group">
    		<label >Enter SubCategory Name</label>
    		<input name="subcategoryName" type="text" class="form-control" required="required"  placeholder="SubCategory name" id="subcategoryName"/>
  		</div>
  		<div class="form-group">
    		<label >Enter Product Name</label>
    		<input name="productName" type="text" class="form-control" required="required"  placeholder="Enter product name" id="productName"/>
  		</div>
  		<div class="form-group">
    		<label >Enter Description</label>
    		<input name="description" type="text" class="form-control" required="required"  placeholder="Enter Description" id="description"/>
  		</div>
  		<div class="form-group">
    		<label for="imageUrl">Upload a Image here</label>
    		<input required="required" type="file"  id="imageUrl" name="imageUrl" class="btn btn-default btn-lg" placeholder="Upload a image"/>
  		</div>
  		<div class="form-group">
    		<label >Enter Available stock</label>
    		<input name="stock" type="text" class="form-control" required="required"  placeholder="Enter stock" id="stock"/>
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
