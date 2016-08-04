<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <script src="js/jquery.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
</head>
<body>
<c:if test="${!empty cart}">
<table class="table table-striped">
<tr>
<td colspan="2">ITEM</td>
<td>QUANTITY</td>
<td>PRICE</td>
<td>SUBTOTAL</td>
</tr>
<c:forEach items="${cart}" var="cart">
<tr>
<td style="padding-left: 0px; padding-right: 0px;height: 108px;width: 79px;">
<img src="<c:out value="${cart.product.imageUrl}"/>" width="100px" height="100px" /></td>
<td><h2><c:out value="${cart.product.name}"/></h2>
<form method="POST" action="removeCart.html" >
<input name="cartId" id="cartId" value="${cart.id}" type="hidden"/>
<button class="btn btn-danger"type="submit" 
	style="padding-left: 0px; padding-right: 5px; padding-bottom: 1px;
	padding-top: 1px; width: 125px; margin-left: 0px;"><i >Remove</i></button>
</form></td>
<td><c:out value="${cart.quantity}"/></td>
<td><c:out value="${cart.product.price}"/></td>
<td><c:out value="${cart.totalPrice}"/></td>
</tr>
</c:forEach>
</table>
<form method="POST" action="order.html">
<button type="submit" class="btn " style="background-color: orange;margin-left: 557px;height: 40px;width: 246px;">PLACE ORDER</button>
</form>
</c:if>
<c:if test="${empty cart}">
<h2>There are no items in this cart. </h2>
<a href="home.html" target="_top"><button class="btn btn-info">Continue Shopping</button></a></c:if>
<br>

</body>
</html>