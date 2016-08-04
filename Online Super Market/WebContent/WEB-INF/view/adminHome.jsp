<!DOCTYPE html>
<html >
<head>
  <title>Home page</title>
  <meta charset="utf-8">
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <script src="js/jquery.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
</head>
<body width="50%">
<div id="header" class="well " style="background-color: #0059b3; color:white;font-size: 30px;padding-bottom: 0px;padding-top: 0px;height: 129px;border-top-width: 0px;width: 998px;">
  <div class="row">
    <div class="col-sm-9">
     <table><tr><td><img src="images/icon.png" style="height: 143px;width: 165px;"/></td>
     <td style="width: 645px; "> 
      <label style="color:white;font-size: 30px;font-style: italic;">
      MK Groceries</label></td></tr>
      </table></div>
    <div class="col-sm-3">
<nav class="navbar">
 
    <ul class="nav">
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#" style="padding-left: 0px;padding-top: 0px;padding-right: 0px;
        padding-bottom: 0px;    width: 0px;    height: 0px;">
        <p style="font-family: sans-serif;font-size:medium;color:white;margin-left: 103px;margin-top: 35px;">${user.firstName}</p></a>
        <ul class="dropdown-menu" style=" top: 23px;right: 0px;height: 106px;width: 60px;border-right-width: 0px;border-left-width: 0px;left: 71px;">
          <li><a href="#"><button type="button" class="btn btn-link" data-toggle="modal" data-target="#myModal">Profile</button></a></li>
          <li><a href="userHome.html" style="margin-left: 0px;padding-left: 35px;">User Page</a></li>
          <li><a href="logout.html" style="margin-left: 0px;padding-left: 35px;">Logout</a></li>
        </ul>
      </li>
    </ul>
</nav>
</div></div>
</div>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#" style="color:#0059b3 ">ADMIN PANEL</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="dropdown"><a style="color:#0059b3 " class="dropdown-toggle" data-toggle="dropdown">
      <img src="images/Category.png" width="20px" height="20px"/> Category<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="redirectCategoryInsert.html" target="iframe">Insert Category</a></li>
          <li><a href="viewCategories.html" target="iframe">View Category </a></li>
          <li><a href="redirectCategoryUpdate.html" target="iframe">Update Category </a></li>
          <li><a href="redirectCategoryDelete.html" target="iframe">Delete Category</a></li>
        </ul>
      </li>
      <li class="dropdown"><a style="color:#0059b3 " class="dropdown-toggle" data-toggle="dropdown">
      <img src="images/subcategory.png" width="20px" height="20px"/>Subcategory<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="redirectSubcategoryInsert.html" target="iframe">Insert Subcategory</a></li>
	       <li><a href="viewSubcategories.html" target="iframe">View Subcategory </a></li>
          <li><a href="redirectSubcategoryUpdate.html" target="iframe">Update Subcategory </a></li>
          <li><a href="redirectSubcategoryDelete.html" target="iframe">Delete Subcategory</a></li>
        </ul>
      </li>
     <li class="dropdown"><a style="color:#0059b3 " class="dropdown-toggle" data-toggle="dropdown">
     <img src="images/product.png" width="20px" height="20px"/> Product<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="redirectProductInsert.html" target="iframe">Insert Product</a></li>
          <li><a href="viewProducts.html" target="iframe">View Product</a></li>
          <li><a href="redirectProductUpdate.html" target="iframe">Update Product </a></li>
          <li><a href="redirectProductDelete.html" target="iframe">Delete Product</a></li>
        </ul>
      </li>
    </ul>
  </div>
</nav>
<div class="container-fluid">
  <div class="row">
		    <div class="col-sm-12">
		   <div  class="embed-responsive embed-responsive-16by9">
          			<iframe height="400px" width="100%" src="viewCategories.html" 
           name="iframe"></iframe>
         </div>
         </div> 
        </div>
      </div>

<div class="container">
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-sm">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h2 class="modal-title">${user.firstName} ${user.lastName}</h2>
        </div>
        <div class="modal-body">
          <h3>Email Id</h3><p>${user.email}</p>
          <h3>Mobile Number</h3><p>${user.mobileNumber}</p>
          <h3>Address</h3><p>${user.address}</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>

