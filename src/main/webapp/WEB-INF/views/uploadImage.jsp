<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
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

<!--  <div class="container">
	<div class="row">
		<h2>Create your snippet's HTML, CSS and Javascript in the editor tabs</h2>
        
        
       <div class="col-md-7 ">
-->
</head>
<body>
<form class="form-horizontal" method="POST" enctype="multipart/form-data">

<div class="panel panel-default">
  <div class="panel-heading">  <h2 >Update Profile</h2></div>
   
  
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
            <h3 style="color:#00b1b1;">Change profile picture </h3></span>
                     <input type="file" name="userImage"/><br/>
                      <input id="imageName" name="imageName" type="text" placeholder="imageName" class="input-xlarge">
                      <input type="submit" value="Update" />
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