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
<c:if test="${!empty user}">
<c:if test="${!empty cart}">
<table class="table table-hover">
<tr>
<td colspan="2">ITEM</td>
<td>QUANTITY</td>
<td>DELIVERY ADDRESS</td>
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
<td><c:out value="${user.address}"/></td>
<td><c:out value="${cart.totalPrice}"/></td>
</tr>
</c:forEach>
</table>
<h2 style="margin-left: 447px;">Estimated Total = <c:out value="${total}"/></h2>
<form method="POST" action="confirmOrder.html">
<input name="total" id="total" value="<c:out value="${total}"/>" type="hidden"/>
<h3 style="margin-left: 447px;">Payment Type:</h3>
<select class="btn btn-info" style="margin-left: 480px;height: 43px;width: 232px;padding-left: 66px;padding-right: 0px;margin-bottom: 0px;" name="paymentType" >
  <option  id="paymentType" value="Credit Card">Credit Card</option>
  <option  id="paymentType" value="Debit Card">Debit Card</option>
  <option  id="paymentType" value="Net Bank">Net Bank</option>
  <option id="paymentType" value="Cash On Delivery">Cash On Delivery</option>
</select>
<button type="submit" class="btn " style="background-color: orange;margin-left: 478px;
height: 40px;width: 233px;margin-top: 20px;">CONFIRM ORDER</button>
</form>
</c:if>
</c:if>
<c:if test="${empty user}">
<h2>Get started with our secure login flow<a href="login.html" target="_top">
<button style="margin-left: 13px;" class="btn btn-primary">LOGIN</button></a></h2>
</c:if>
</body>
</html>