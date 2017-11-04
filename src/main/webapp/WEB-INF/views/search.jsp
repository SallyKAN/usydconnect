<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<jsp:include page="header.jsp"></jsp:include>
<head>
<title>UsydConnect</title>
<link rel="stylesheet" type="text/css"
href="<c:url value="/resources/style.css" />" >

<style> 
              input.hidden {
    position: absolute;
    left: -9999px;
}

#profile-image1 {
    cursor: pointer;
  
     width: 100px;
    height: 100px;
	border:2px solid #03b1ce ;}
	.tital{ font-size:16px; font-weight:500;}
	 .bot-border{ border-bottom:1px #f8f8f8 solid;  margin:5px 0  5px 0}	
</style>
</head>

<!--  <div class="container">
	<div class="row">
		<h2>Create your snippet's HTML, CSS and Javascript in the editor tabs</h2>
        
        
       <div class="col-md-7 ">
-->
<body>
<form class="form-horizontal" method="POST">
<div class="panel panel-default">
  <div class="panel-heading">  <h2 >Search for users</h2></div>
   
  
   <div class="panel-body">
       
    <div class="box box-info">
        
            <div class="box-body">
                     <div class="col-sm-6">
                     <div  align="center"> <img alt="User Pic" src="https://x1.xingassets.com/assets/frontend_minified/img/users/nobody_m.original.jpg" id="profile-image1" class="img-circle img-responsive"> 
                
                <input id="profile-image-upload" class="hidden" type="file">
<!--<div style="color:#999;" >click here to change profile image</div>-->

                <!--Upload Image Js And Css-->
                     
                     </div>
              
              <br>
    
              <!-- /input-group -->
            </div>
            <div class="col-sm-6">
            <h3 style="color:#00b1b1;">Search for existing users </h3></span>
                      <input id="username" name="username" type="text" placeholder="username" class="input-xlarge">
                      <input type="submit" value="Search" />
            </div>
            <hr style="margin:5px 0 5px 0;">
            
            </div>
            </div>
            </div>
            </div>
            </form>
            <jsp:include page="footer.jsp" />
            </body>
            </html>