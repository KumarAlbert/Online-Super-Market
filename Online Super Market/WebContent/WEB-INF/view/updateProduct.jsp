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
    var name = document.getElementById('productName').value;
	var stringForProduct = /^([a-zA-Z ]{2,30})$/ 
    if (stringForProduct.test(name)) {
        retuen true;
    } else {
    	alert("Enter valid name!!");
 	    return false;	
    }

}
</script>
</head>
<body>
<div class="alert">
  <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> 
  <strong>Info!</strong> Please enter valid product name by verifying it on product details.
</div>
<div class="col-sm-6">
<div class="panel ">
  <h2>Update Product</h2>
	<form onsubmit="return validation()" method="POST" action="productUpdate.html">
  		<div class="form-group">
    		<label >Enter Product Name</label>
    		<input name="productName" id = "productName"type="text" class="form-control" required="required" placeholder="Name of the Product"/>
  		</div>
  		<div class="form-group">
  	        <label>Select your choice to be updated</label>
                <select name="choice" style="margin-left: 22px; padding-left: 22px;">
                    <option value="null">--Select Option--</option>
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
