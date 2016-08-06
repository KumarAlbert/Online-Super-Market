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
  $('.carousel').carousel({
   interval: 10
  });
 </script>   
  <script>
function productValidation() {
    var quantity = document.getElementById('quantity').value;
    var stock = document.getElementById('stock').value;
	if(stock < quantity){
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
<div id="myCarousel" class="carousel slide" data-ride="carousel" data-interval="3000">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
    <li data-target="#myCarousel" data-slide-to="3"></li>
    <li data-target="#myCarousel" data-slide-to="4"></li>
    <li data-target="#myCarousel" data-slide-to="5"></li>
    <li data-target="#myCarousel" data-slide-to="6"></li><li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="7"></li>
    <li data-target="#myCarousel" data-slide-to="8"></li>
    <li data-target="#myCarousel" data-slide-to="9"></li>
    <li data-target="#myCarousel" data-slide-to="10"></li>
    <li data-target="#myCarousel" data-slide-to="11"></li>
    <li data-target="#myCarousel" data-slide-to="12"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    <div class="item active">
      <img src="images/offers/offer2.png" style="width:  100%; height: 263px;" alt="Chania">
    </div>
    <div class="item">
      <img src="images/offers/offer3.bmp" style="width:  100%; height: 263px;" alt="Chania">
    </div>
    <div class="item">
      <img src="images/offers/offer4.bmp" style="width:  100%; height: 263px;" alt="Chania">
    </div>
    <div class="item">
      <img src="images/offers/offer5.jpg" style="width:  100%; height: 263px;" alt="Chania">
    </div>
    <div class="item ">
      <img src="images/offers/offer6.jpg" style="width:  100%; height: 263px;" alt="Chania">
    </div>
    <div class="item ">
      <img src="images/offers/offer7.png" style="width:  100%; height: 263px;" alt="Chania">
    </div>
    <div class="item ">
      <img src="images/offers/offer8.bmp" style="width:  100%; height: 263px;" alt="Chania">
    </div>
    <div class="item ">
     <a href="vegtables.html"><img src="images/offers/offer9.png" style="width:  100%; height: 263px;" alt="Chania"></a>
    </div>
    <div class="item ">
      <img src="images/offers/offer10.png" style="width:  100%; height: 263px;" alt="Chania">
    </div>
    <div class="item ">
      <img src="images/offers/offer11.jpg" style="width:  100%; height: 263px;" alt="Chania">
    </div>
    <div class="item ">
      <img src="images/offers/offer12.png" style="width:  100%; height: 263px;" alt="Chania">
    </div>
  </div>

  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>      		</div>
      		<div class="row">
      		 <c:forEach items="${productFilter}" var="product">
        		<div class="col-sm-3" style="padding-left: 50px;">
          			<div class="panel" style="width: 25%; padding-right: 0px;">
             		 <img alt="images/banana.jpg" src="<c:out value="${product.imageUrl}"/>" height="100px" width="100px"/>
             		 <i><c:out value="${product.name}"/></i>
             		 <i><c:out value="${product.description}"/></i>
             		 <table style="margin-top: 13px;"><tr><td>MP: </td><td style="padding-left: 10px;"><c:out value="Rs${product.price}"/></td></tr></table>
     					<p></p>
						<p></p>
						<form method="POST" action="saveCart.html">
				    		<input name="productPrice" id="product" value="${product.price}" type="hidden"/>
							    <input name="product" id="product" value="${product.name}" type="hidden"/>
							    	<table><tr><td><label>Qty</label></td><td><input name="quantity" id="quantity" type="text" style="width:25px;height:25px;margin-left: 5px;"></td></tr></table>
  							   	     <input  id="stock" value="${product.stock}" type="hidden"/>
									<i id="inStock" style="color:green"></i>
									<i id="outStock" style="color:red"></i><p></p>
		    						<span><button type="submit"  class="btn btn-success" style=" padding-bottom: 0px;">Add to <p class="glyphicon glyphicon-shopping-cart"></p></button></span>
		    		
		    		</form>
             		 <form method="POST" action="singleFruit.html"><h4>
             		 <input name="fruit" value="<c:out value="${product.name}"/>" type="hidden"/>
             		 <button type="submit" class="btn btn-link"><c:out value="${product.name}"/></button></h4></form>
          			</div>
        </div>
        </c:forEach>
      </div>
         </div>

</body>
</html>