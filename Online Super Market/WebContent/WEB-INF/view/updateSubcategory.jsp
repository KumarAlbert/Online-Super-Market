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
<script>
function validation() {
    var subcategoryName = document.getElementById('existingSubcategoryName').value;
    var subcategoryNameToBeUpdated = document.getElementById('subcategoryName').value;
	var stringForSubCategory = /^([a-zA-Z&]{2,30})$/ ;
    if (stringForSubCategory.test(subcategoryName)) {
    	if(stringForSubCategory.test(subcategoryNameToBeUpdated)) {
    	    return true;
        } else {
    	    alert("Enter valid name!!");
    	    return false;
        }
    } else {
    	alert("Enter valid new name!!");
 	    return false;	
    }

}
</script>
</head>
<body>
<div class="alert">
  <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> 
  <strong>Info!</strong> Please enter valid Subcategory name by verifying it on Subcategory details.
</div> 
<div class="col-sm-6">
<div class="panel">
  <h2>Update Subcategory</h2>
	<form onsubmit="return validation()" method="POST" action="subcategoryUpdate.html">
  		<div class="form-group">
    		<label >Enter Existing Subcategory Name</label>
    		<input name="existingSubcategoryName" id="existingSubcategoryName" type="text" class="form-control" required="required" placeholder="Existing Subcategory name"/>
  		</div>
  		<div class="form-group">
    		<label>Enter Subcategory Name</label>
    		<input name="subCategoryName" id="subCategoryName" type="text" class="form-control" required="required" placeholder="Subcategory of the Product"/>
  		</div>
  		<center><button type="submit" class="btn btn-info">Submit</button>
  		<button type="reset" class="btn btn-danger">Reset</button></center>
	</form>
	</div></div>
<div class="col-sm-6">
<div class="panel">
  <h2>Subcategory Details</h2>
          <table class="table table-striped" bgcolor="black" width="100%">
            <tr style="color: black;text-align: center;" height="40px">
                <td><dt>Subcategory Name</dt></td>
                <td><dt>Category Name</dt></td>
            </tr>
        <c:forEach items="${subcategory}" var="subcategory">
            <tr style="background-color:white;color: black;text-align: center;" height="30px" >
                <td><c:out value="${subcategory.name}"/></td>
                <td><c:out value="${subcategory.category.name}"/></td>
            </tr>
        </c:forEach>
        </table>
        <br>
	</div></div>
</body>
</html>