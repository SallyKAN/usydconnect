<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html>
<jsp:include page="header.jsp"></jsp:include>
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

.search-form .form-group {
  float: right !important;
  transition: all 0.35s, border-radius 0s;
  width: 32px;
  height: 32px;
  background-color: #fff;
  box-shadow: 0 1px 1px rgba(0, 0, 0, 0.075) inset;
  border-radius: 25px;
  border: 1px solid #ccc;
}
.search-form .form-group input.form-control {
  padding-right: 20px;
  border: 0 none;
  background: transparent;
  box-shadow: none;
  display:block;
}
.search-form .form-group input.form-control::-webkit-input-placeholder {
  display: none;
}
.search-form .form-group input.form-control:-moz-placeholder {
  /* Firefox 18- */
  display: none;
}
.search-form .form-group input.form-control::-moz-placeholder {
  /* Firefox 19+ */
  display: none;
}
.search-form .form-group input.form-control:-ms-input-placeholder {
  display: none;
}
.search-form .form-group:hover,
.search-form .form-group.hover {
  width: 100%;
  border-radius: 4px 25px 25px 4px;
}
.search-form .form-group span.form-control-feedback {
  position: absolute;
  top: -1px;
  right: -2px;
  z-index: 2;
  display: block;
  width: 34px;
  height: 34px;
  line-height: 34px;
  text-align: center;
  color: #3596e0;
  left: initial;
  font-size: 14px;
}
</style>

<head>
 <meta charset="UTF-8">
    <title>UsydConnect</title>
    <link rel="stylesheet" type="text/css"
href="<c:url value="/resources/style.css" />" >
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link href='https://fonts.googleapis.com/css?family=Satisfy' rel='stylesheet' type='text/css'>
    <link href="https://fonts.googleapis.com/css?family=Arima+Madurai" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Sans" rel="stylesheet">
   <link href="https://fonts.googleapis.com/css?family=Kaushan+Script" rel="stylesheet">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="resources/style.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>


<!--  <div class="container">
	<div class="row">
		<h2>Create your snippet's HTML, CSS and Javascript in the editor tabs</h2>
        
        
       <div class="col-md-7 ">
-->
<div class="panel panel-default">
  <div class="panel-heading">  <h2 >User Profile</h2>
  <a href="<c:url value="/users/search/" />">Search for other users</a>
  <li>
                <a href="<c:url value="/msg/turntotalked"/>">
                    <span class="glyphicon glyphicon-comment">chat</span>
                </a>
            </li>
  </div>
  
   <!--  <a href="<c:url value="/users/search/" />">Search for other users</a><br> -->
  
   <div class="panel-body">
       
    <div class="box box-info">
        
            <div class="box-body">
                     <div class="col-sm-6">
                     <div  align="center"> <img alt="User Pic" src="https://x1.xingassets.com/assets/frontend_minified/img/users/nobody_m.original.jpg" id="profile-image1" class="img-circle img-responsive"> 
                
                <input id="profile-image-upload" class="hidden" type="file">
<!--<div style="color:#999;" >click here to change profile image</div>-->
<c:choose>
    <c:when test="${username == user.getUsername()}">
    	<a href="<c:url value="/users/uploadImage/" />">Upload Profile Picture</a><br>
        <a href="<c:url value="/users/settings/" />">Settings - update profile</a><br>
        <a href="<c:url value="/users/friends" />">View Friends</a><br>
        
    </c:when> 
    <c:when test = "${profile.getAdmin() == 1 }">
    	<a href="<c:url value="/users/delete/" />">Delete this account</a><br>
    </c:when> 
    <c:when test = "${profile.getAdmin() == 0 }">
    	<a href="<c:url value="/users/addFriend/${user.username}" />">Add Friend</a><br>
    </c:when>  
    <c:otherwise>
    </c:otherwise>
</c:choose>

                <!--Upload Image Js And Css-->
           
              
   
                
                
                     
                     
                     </div>
              
              <br>
    
              <!-- /input-group -->
            </div>
            <div class="col-sm-6">
            <h1 style="color:#00b1b1;">${user.name} </h1></span>
            <h3 style="color:#00b1b1;">${user.username} </h3></span>     
			<h3 style="color:#00b1b1;">${user.email} </h3></span>         
			<!-- <c:choose>
    			<c:when test="${username == user.getUsername()}">
    				<a href="<c:url value="/users/friends" />">View Friends</a><br>
        		</c:when> 
    			<c:otherwise>
    			<a href="<c:url value="/users/addFriend" />">Add user as friend</a>
        		<br />
    			</c:otherwise>
			</c:choose>-->
            </div>
            <div class="clearfix"></div>
            <hr style="margin:5px 0 5px 0;">
    

<div class="col-sm-5 col-xs-6 tital " >Gender:</div><div class="col-sm-7 col-xs-6 ">${user.gender}</div>
     <div class="clearfix"></div>
<div class="bot-border"></div>   
<div class="col-sm-5 col-xs-6 tital " >Nationality:</div><div class="col-sm-7 col-xs-6 ">${user.nationality}</div>
     <div class="clearfix"></div>
<div class="bot-border"></div>
<div class="col-sm-5 col-xs-6 tital " >Faculty:</div><div class="col-sm-7 col-xs-6 ">${user.faculty}</div>
     <div class="clearfix"></div>
<div class="bot-border"></div>

<div class="col-sm-5 col-xs-6 tital " >Area of study:</div><div class="col-sm-7"> ${user.major}</div>
  <div class="clearfix"></div>
<div class="bot-border"></div>

<div class="col-sm-5 col-xs-6 tital " >Year:</div><div class="col-sm-7"> ${user.year}</div>
  <div class="clearfix"></div>
<div class="bot-border"></div>
<div class="col-sm-5 col-xs-6 tital " >Degree type:</div><div class="col-sm-7"> ${user.degree}</div>
  <div class="clearfix"></div>
<div class="bot-border"></div>


<div class="clearfix"></div>
	<hr style="margin:5px 0 5px 0;">


<div class="col-sm-6 col-xs-6 tital " > <h3 style="color:#308079;"> Posts:</h3> <c:forEach items="${posts}" var="posts" >
   <div class="posts">
    <h3><a href="<c:url value="/posts/view/${posts.id}"/>">${posts.title}</a> </h3>
    <p>${posts.message}</p>  
  </div>
</c:forEach>


            <!-- /.box-body -->
          </div>
          <!-- /.box -->

        </div>
       
            
    </div> 
    </div>
</div>  
    <script>
              $(function() {
    $('#profile-image1').on('click', function() {
        $('#profile-image-upload').click();
    });
});       
              </script> 
       
       
       
       
       
       
       
       
       
   </div>
</div>
<jsp:include page="footer.jsp" />
</html>