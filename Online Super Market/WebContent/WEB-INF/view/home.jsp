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
    <div class="col-sm-10">
     <table><tr><td><img src="images/icon.png" style="height: 143px;width: 165px;"/></td>
     <td style="width: 645px; "> 
      <label style="color:white;font-size: 30px; font-style: ">
      MK Groceries</label></td></tr>
      </table></div>
    <div class="col-sm-2">
<a href="login.html" style="font-family: sans-serif;color:white;font-size:medium; ;margin-left: 73px;">Log In</a>
<a href="cart.html" target="iframe"><img src="images/cart.png" width="50px" height="50px" style=" margin-left: 72px;"/></a>
      </div></div>
</div>
<div class="container-fluid">
  <div class="row">
 	   <div class="col-sm-2 sidenav">
		 <ul class="list-group" style=" ">
  			<li class="list-group-item" style=" background-color:#0059b3;padding-left: 0px; padding-right: 0px;padding-top: 0px;padding-bottom: 0px;">
  				<button class="btn btn-link dropdown-toggle" type="button" data-toggle="dropdown" style="color:white;">Fruits&Vegtables</button>
    			<ul class="dropdown-menu">
       			     <li><a href="fruits.html"  target="iframe">Fruits</a></li>
    				  <li><a href="#" target="">Vegtables</a></li>
    			</ul>
    		</li>
			<li class="list-group-item" style="padding-left: 0px; padding-right: 0px;padding-top: 0px; background-color:#0059b3;padding-bottom: 0px;">
  				<button class="btn btn-link dropdown-toggle" type="button" data-toggle="dropdown" style="color:white;">Flowers&Cakes</button>
    			<ul class="dropdown-menu">
       			     <li><a href=""  target="">Flowers</a></li>
    				  <li><a href="#" target="">Cakes</a></li>
    			</ul>
		    </li>
			<li class="list-group-item" style="padding-left: 0px; background-color: #0059b3 ;padding-right: 0px;padding-top: 0px;padding-bottom: 0px;">
  				<button class="btn btn-link dropdown-toggle" style="color:white;" type="button" data-toggle="dropdown">Flowers&Cakes</button>
    			<ul class="dropdown-menu">
       			     <li><a href=""  target="">Flowers</a></li>
    				  <li><a href="#" target="">Cakes</a></li>
    			</ul>
    		</li>
    		</ul>
			</div>
 	  <div class="col-sm-10">
		   <div  class="embed-responsive embed-responsive-16by9">
          			<iframe height="400px" width="50%" src="homepage.html" 
           name="iframe"></iframe>
         </div>
         </div> 
        </div>
      </div>


</body>
</html>
