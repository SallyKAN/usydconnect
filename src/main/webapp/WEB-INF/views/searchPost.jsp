<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<html>
  <head>
  <style type="text/css">
  .container-fluid{

    margin: 0;
    padding:0;

}


#menu{
    /*Navigation Bar*/
    background-color: whitesmoke; /*change default bootstrap*/
    border-color: white; /*change default bootstrap*/
    font-family: 'Josefin Sans', sans-serif; /*google font*/

    -webkit-border-radius: 0; /*change default bootstrap*/
    -moz-border-radius: 0; /*change default bootstrap*/
    border-radius: 0; /*change default bootstrap*/

    padding-left: 10px;
    padding-right: 10px;
    max-height: 75px;
    margin: 0;


}

#branding{
    /*logo*/

    color: #000000;
    font-family: 'Kaushan Script', cursive; /*google font*/
    font-size: 40px;
}

/*css for right navbar options*/
#menubuttons{
    position: relative;
    top:-40px;
    margin: 5px;
    font-size:20px;
        background-color: whitesmoke;
    border: 2px transparent;
    border-radius: 5px;
    -webkit-transition-duration: 1s; /* Safari */
    transition-duration: 1s;
}

#menubuttons>li:hover{
    background-color: black;

    
}
#menubuttons>li>a{

    color: #000000;



}




#menubuttons>li>a:hover{

    color: white;


}

#searchbutton{

    color: #000000;
    padding:8px;
    background-color:red;
    font-size:15px;
}

#searchbutton:hover{
    color: red;
    background-color: #000000;
}


input[type=text], select {
    margin-top: 10px;
    height: 35px;
    width: 500px;
    margin-left: 75px;


}

.loginstatus{
    font-size: 15px;
    padding:10px;

}
#id_honeypot {
    display: none;
}
.post-title{
     padding-top: 20px;
    padding-bottom: 20px;

}
author{


    font-style: italic;
    font-family: "Century Gothic";
    font-size: small;

}
.post-date{

         font-family: "Century Gothic";
    font-size: small;

    padding-top: 10px;
     padding-bottom: 20px;
      border-bottom: solid slategray 2px;
}
.float-left{
    float:left;
}

.float-right{
    float:right;
}
  </style>
    <title>UsydConnect</title>
    <jsp:include page="header.jsp" />
    </head>
  <body>
  
 <div class="row">
        <div class="col-md-2">
        </div>
            <div class="col-md-8">
            <h1>Searched Posts for "${searchTerm}"</h1>
             
                <c:forEach items="${searchPosts}" var="post" >
   				<div class="post-title">
            <h3><a href="<c:url value="/posts/view/${post.id}"/>"> ${post.title}</a></h3>
            <span class="author float-right"> published by: <a href="<c:url value = "/users/profile/${username}"/>">${post.postUsername}</a></span>
        </div>
        <div class="post-date">
            <div class="float-left"> ${post.getTime()} </div>
            <div class="float-right">${post.commentCount} comments </div>
        </div>
				</c:forEach>
               
     </div>
     </div>
     
</body>
<jsp:include page="footer.jsp" />
</html>