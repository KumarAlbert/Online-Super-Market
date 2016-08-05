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
<script>
function validation() {
    var name = document.getElementById('categoryName').value;
	var string = /^([a-zA-Z&]{2,30})$/ ;
    if (string.test(name)) {
    	return true;
    } else {
    	alert("Enter valid category name!!");
    	return false;
    }

}
</script>
</head>
<body>
<div class="alert">
  <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> 
  <strong>Note!</strong> Check Category details before adding new category.
</div>
<div class="col-sm-6">
<div class="panel">
  <h2>Add Category</h2>
	<form onsubmit="return validation()" method="POST" action="categoryInsert.html">
  		<div class="form-group">
    		<label >Category Name</label>
    		<input name="categoryName" type="text" class="form-control " required="required" placeholder="Enter Category name" id="categoryName"/>
  		</div>
  		<center><button type="submit" class="btn btn-info">Submit</button>
  		<button type="reset" class="btn btn-danger">Reset</button></center>
	</form>
	</div></div>
<div class="col-sm-6">
<div class="panel">
  <h2>Category Details</h2>
        <div>
          <table class="table table-striped" bgcolor="black" width="100%">
          <thead>
            <tr style="color: black;text-align: center;" height="40px">
                <td><dt>Category Id</dt></td>
                <td><dt>Category Name</dt></td>
            </tr>
          </thead>  
          <c:forEach items="${category}" var="category">
          <tbody>
            <tr style="background-color:white;color: black;text-align: center;" height="30px" >
                <td><c:out value="${category.id}"/></td>
                <td><c:out value="${category.name}"/></td>
            </tr>
          </tbody>
          </c:forEach>
        </table>
        <br>
        </div>
	</div></div>
</body>
</html>
