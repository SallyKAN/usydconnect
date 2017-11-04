<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

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
.require {
    color: #666;
}
label small {
    color: #999;
    font-weight: normal;
}
  </style>
    <title>Create post</title>
     <jsp:include page="header.jsp" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link href='https://fonts.googleapis.com/css?family=Satisfy' rel='stylesheet' type='text/css'>
    <link href="https://fonts.googleapis.com/css?family=Arima+Madurai" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Sans" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Kaushan+Script" rel="stylesheet">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" type="text/css" src="style.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="resources/style.css"/>
    
</head>

<body>

<div class = "container">

	<div class="row">
	    
	    <div class="col-md-8 col-md-offset-2">
	    <h1>Create post</h1>
<form  method="POST" >
    <input type="hidden" name="username" readonly value="${username}"/>
   
    <div class="form-group">
    		        <label for="title">Title <span class="require">*</span></label>
    		        <input type="text" class="form-control" id="title"  name="title" />
    		    </div>
    <div class="form-group">
    <label for="description">Tag:</label>
    <select id = "selectedTags" name ="selectedTags">
   		<c:forEach items="${allTags}" var="allTags" >
         	<option value="${allTags.name}">${allTags.name}</option>
   		 </c:forEach>
   		 </select>
    		        
    		        <input rows="5" class="form-control" id="tags" name="tags" ></textarea>
    	</div>
  <div class="form-group">
    		        <label for="description">Message:</label>
    		        <textarea rows="5" class="form-control" id="message" name="message"></textarea>
    		    </div>
 	 
 	
	<div class="form-group">
    		        <button type="submit" class="btn btn-primary">
    		            Create
    		        </button>
    		        <button class="btn btn-default">
    		            Cancel
    		        </button>
    </form>
		</div>
		
	</div>
</div>

<jsp:include page="footer.jsp" />
 </html>