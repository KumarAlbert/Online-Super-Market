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
<title>Subcategory</title>
</head>
<body>
<div class="col-sm-12">
<div class="panel panel-primary">
  <div class="panel-heading">Subcategories</div>
 	<div class="panel-body">
        <div>
          <table class="table table-striped" bgcolor="black" width="100%">
            <tr style="color: black;text-align: center;" height="40px">
                <td><dt>Subcategory Id</dt></td>
                <td><dt>Subcategory Name</dt></td>
                <td><dt>Category Name</dt></td>
                <td><dt>Created By</dt></td>
                <td><dt>Created At</dt></td>
                <td><dt>Modified By</dt></td>
                <td><dt>Modified At</dt></td>
            </tr>
        <c:forEach items="${subcategory}" var="subcategory">
            <tr style="background-color:white;color: black;text-align: center;" height="30px" >
                <td><c:out value="${subcategory.id}"/></td>
                <td><c:out value="${subcategory.name}"/></td>
                <td><c:out value="${subcategory.category.name}"/></td>
                <td><c:out value="${subcategory.createdBy}"/></td>
                <td><c:out value="${subcategory.createdAt}"/></td>
                <td><c:out value="${subcategory.modifiedBy}"/></td>
                <td><c:out value="${subcategory.modifiedAt}"/></td>
            </tr>
        </c:forEach>
        </table>
        <br>
        </div>
	</div></div></div>
</body>
</html>

