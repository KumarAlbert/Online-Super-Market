   <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Banana</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script>
function registerValidation() {
    var quantity = document.getElementById('quantity').value;
    var stock = document.getElementById('stock').value;
	if(quantity <= stock){
		return true;
	}
	else {
	 	alert("We have only  "+stock+"  products");
	 	return false;
 }
}
</script>
</head>
<body>
<div class="row">
<div class="col-sm-6">
<div class="panel ">
 	<img src="<c:out value="${product.imageUrl}"/>" class="img-responsive" />
  </div>
	</div>
<div class="col-sm-6">
<div class="panel">
	<div class="row">
	<div class="col-sm-10">
  				<h1><c:out value="${product.name}"/></h1> <p></p>
		<h3>Price:<div style="font-style:oblique; ;color:red"><c:out value="Rs ${product.price}"/></div></h3>
		<p></p>
		<h4><b>Description</b></h4><p>
		   <c:out value="${product.description}"/></p>
		<p></p>
		<form method="POST" action="saveCart.html" onsubmit="return registerValidation()">
		    		<label >Quantity</label>
		     <input name="productPrice" id="product" value="${product.price}" type="hidden"/>
		    <input name="product" id="product" value="${product.name}" type="hidden"/>
    		<input  name="quantity" id="quantity" type="text"/>
     	     <input  id="stock" value="${product.stock}" type="hidden"/>
			<i style="margin-left: 141px;">Available:</i> <c:out value="${product.stock}"/><p id="available" style="color:red"></p><p></p>

		    		<span><button type="submit" class="btn btn-success" style=" padding-bottom: 0px;">Add to <p class="glyphicon glyphicon-shopping-cart"></p></button></span>
		    		
		    		</form>
	</div>
</div></div></div>

</div>
</body>
</html>



