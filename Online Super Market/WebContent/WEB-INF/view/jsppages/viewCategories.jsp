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
<title>Category</title>
</head>
<body>
<div class="row">
<div class="col-sm-12">
<div class="panel panel-primary">
  <h2>Categories</h2>
 	<div class="panel-body">
        <div>
          <table class="table table-striped" bgcolor="black" width="100%">
          <thead>
            <tr style="color: black;text-align: center;" height="40px">
                <td><dt>Category Id</dt></td>
                <td><dt>Category Name</dt></td>
                <td><dt>Created By</dt></td>
                <td><dt>Created At</dt></td>
                <td><dt>Modified By</dt></td>
                <td><dt>Modified At</dt></td>
            </tr>
          </thead>  
          <c:forEach items="${category}" var="category">
          <tbody>
            <tr style="background-color:white;color: black;text-align: center;" height="30px" >
                <td><c:out value="${category.id}"/></td>
                <td><c:out value="${category.name}"/></td>
                <td><c:out value="${category.createdBy}"/></td>
                <td><c:out value="${category.createdAt}"/></td>
                <td><c:out value="${category.modifiedBy}"/></td>
                <td><c:out value="${category.modifiedAt}"/></td>
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
