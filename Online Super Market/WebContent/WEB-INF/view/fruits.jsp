<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="css/bootstrap.min.css">
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
	    <div class="col-sm-12">
     		 <div class="panel">
     		 <img alt="images/fruit1.jpg" src="images/fruit.jpg" style="height: 176px; width: 786px;"/>
      		</div>
      		<div class="row">
      		 <c:forEach items="${fruits}" var="fruit">
        		<div class="col-sm-3">
          			<div class="panel">
             		 <img alt="images/banana.jpg" src="<c:out value="${fruit.imageUrl}"/>" height="100px" width="100px"/>
					<h4>MRP:<div style="font-style:oblique; ;color:red"><c:out value="Rs ${fruit.price}"/></div></h4>
					<p></p>
						<p></p>
						<form method="POST" action="saveCart.html" onsubmit="return registerValidation()">
				    		<label >Quantity</label>
						     <input name="productPrice" id="product" value="${fruit.price}" type="hidden"/>
							    <input name="product" id="product" value="${fruit.name}" type="hidden"/>
  							  		<input  name="quantity" id="quantity" type="text"style="width: 28px;height: 23px;"/>
  							   	     <input  id="stock" value="${fruit.stock}" type="hidden"/>
									<i style="margin-left: 12px;">Available:</i> <c:out value="${fruit.stock}"/>
									<p id="available" style="color:red"></p><p></p>
		    						<span><button type="submit" class="btn btn-success" style=" padding-bottom: 0px;">Add to <p class="glyphicon glyphicon-shopping-cart"></p></button></span>
		    		
		    		</form>
             		 <form method="POST" action="singleFruit.html"><h4>
             		 <input name="fruit" value="<c:out value="${fruit.name}"/>" type="hidden"/>
             		 <button type="submit" class="btn btn-link"><c:out value="${fruit.name}"/></button></h4></form>
          			</div>
        </div>
        </c:forEach>
      </div>
         </div>

</body>
</html>