<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<style type="text/css">
		#map {
        height: 400px;
        width: 100%;
       }
		.social:hover {
     -webkit-transform: scale(1.1);
     -moz-transform: scale(1.1);
     -o-transform: scale(1.1);
 }
 .social {
     -webkit-transform: scale(0.8);
     /* Browser Variations: */
     
     -moz-transform: scale(0.8);
     -o-transform: scale(0.8);
     -webkit-transition-duration: 0.5s;
     -moz-transition-duration: 0.5s;
     -o-transition-duration: 0.5s;
 }

/*
    Multicoloured Hover Variations
*/
 
 #social-fb:hover {
     color: #3B5998;
 }
 #social-tw:hover {
     color: #4099FF;
 }
 #social-gp:hover {
     color: #d34836;
 }
 #social-em:hover {
     color: #f39c12;
 }
 #txt-railway {
    /*logo*/

    color: #000000;
    font-family: 'Kaushan Script', cursive; /*google font*/
    font-size: 40px;
}
 </style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link href='https://fonts.googleapis.com/css?family=Satisfy' rel='stylesheet' type='text/css'>
    <link href="https://fonts.googleapis.com/css?family=Arima+Madurai" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Sans" rel="stylesheet">
   <link href="https://fonts.googleapis.com/css?family=Kaushan+Script" rel="stylesheet">
 <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
 <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet" integrity="sha256-MfvZlkHCEqatNoGiOXveE8FIwMzZg4W85qfrfIFBfYc= sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ==" crossorigin="anonymous">
 </head>
<body>
 <div class="container">
<!-- AIzaSyDT5N48vVEf55XZnt6XPMr3pFOwawq1urw -->
 	<div class="text-center center-block">
            <h1 class="txt-railway">- UsydConnect.com -</h1>

                <a href=""><i id="social-fb" class="fa fa-facebook-square fa-3x social"></i></a>
	            <a href=""><i id="social-tw" class="fa fa-twitter-square fa-3x social"></i></a>
	            <a href=""><i id="social-gp" class="fa fa-google-plus-square fa-3x social"></i></a>
	            <a href=""><i id="social-em" class="fa fa-envelope-square fa-3x social"></i></a>
</div>
 <div id="map"></div>
    <script>
      function initMap() {
        var uluru = {lat: -33.888584, lng: 151.18734730000006};
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 4,
          center: uluru
        });
        var marker = new google.maps.Marker({
          position: uluru,
          map: map
        });
      }
      function getIP(json) {
    	    document.write("My public IP address is: ", json.ip);
      }
    </script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDT5N48vVEf55XZnt6XPMr3pFOwawq1urw&callback=initMap">
    </script>
    <script type="application/javascript" src="https://api.ipify.org?format=jsonp&callback=getIP"></script>
</div>

</body>

</html>