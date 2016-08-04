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
<div class="row">
<div class="col-sm-12">
<div class="panel">
        <div>
          <h2>Products</h2>
          <table class="table table-striped" bgcolor="black" width="100%">
          <thead>
            <tr style="color: black;text-align: center;" height="40px">
                <td><dt>Product Id</dt></td>
                <td><dt>Product Name</dt></td>
                <td><dt>Description</dt></td>
                <td><dt>ImageUrl</dt></td>
                <td><dt>Stock</dt></td>
                <td><dt>Price</dt></td>
                <td><dt>SubCategory Name</dt></td>              
                <td><dt>Created By</dt></td>
                <td><dt>Created At</dt></td>
                <td><dt>Modified By</dt></td>
                <td><dt>Modified At</dt></td>
            </tr>
          </thead>
          <c:forEach items="${product}" var="product">
          <tbody>
            <tr style="background-color:white;color: black;text-align: center;" height="50px" >
                <td><c:out value="${product.id}"/></td>
                <td><c:out value="${product.name}"/></td>
                <td><c:out value="${product.description}"/></td>
                <td><c:out value="${product.imageUrl}"/></td>
                <td><c:out value="${product.stock}"/></td>
                <td><c:out value="${product.price}"/></td> 
                <td><c:out value="${product.subcategory.name}"/></td>                              
                <td><c:out value="${product.createdBy}"/></td>
                <td><c:out value="${product.createdAt}"/></td>
                <td><c:out value="${product.modifiedBy}"/></td>
                <td><c:out value="${product.modifiedAt}"/></td>
            </tr>
          </tbody>
        </c:forEach>
        </table>
        <br>
        </div>
	</div></div></div>
	</div>
</body>
</html>
