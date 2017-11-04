<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>UsydConnect</title>
<link rel="stylesheet" type="text/css"
href="<c:url value="/resources/style.css" />" >
<style> 
/*!
 * Datepicker for Bootstrap
 *
 * Copyright 2012 Stefan Petre
 * Licensed under the Apache License v2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 */
.datepicker {
  top: 0;
  left: 0;
  padding: 4px;
  margin-top: 1px;
  -webkit-border-radius: 4px;
  -moz-border-radius: 4px;
  border-radius: 4px;
  /*.dow {
    border-top: 1px solid #ddd !important;
  }*/

}
.datepicker:before {
  content: '';
  display: inline-block;
  border-left: 7px solid transparent;
  border-right: 7px solid transparent;
  border-bottom: 7px solid #ccc;
  border-bottom-color: rgba(0, 0, 0, 0.2);
  position: absolute;
  top: -7px;
  left: 6px;
}
.datepicker:after {
  content: '';
  display: inline-block;
  border-left: 6px solid transparent;
  border-right: 6px solid transparent;
  border-bottom: 6px solid #ffffff;
  position: absolute;
  top: -6px;
  left: 7px;
}
.datepicker > div {
  display: none;
}
.datepicker table {
  width: 100%;
  margin: 0;
}
.datepicker td,
.datepicker th {
  text-align: center;
  width: 20px;
  height: 20px;
  -webkit-border-radius: 4px;
  -moz-border-radius: 4px;
  border-radius: 4px;
}
.datepicker td.day:hover {
  background: #eeeeee;
  cursor: pointer;
}
.datepicker td.day.disabled {
  color: #eeeeee;
}
.datepicker td.old,
.datepicker td.new {
  color: #999999;
}
.datepicker td.active,
.datepicker td.active:hover {
  color: #ffffff;
  background-color: #006dcc;
  background-image: -moz-linear-gradient(top, #0088cc, #0044cc);
  background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#0088cc), to(#0044cc));
  background-image: -webkit-linear-gradient(top, #0088cc, #0044cc);
  background-image: -o-linear-gradient(top, #0088cc, #0044cc);
  background-image: linear-gradient(to bottom, #0088cc, #0044cc);
  background-repeat: repeat-x;
  filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#ff0088cc', endColorstr='#ff0044cc', GradientType=0);
  border-color: #0044cc #0044cc #002a80;
  border-color: rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.25);
  *background-color: #0044cc;
  /* Darken IE7 buttons by default so they stand out more given they won't have borders */

  filter: progid:DXImageTransform.Microsoft.gradient(enabled = false);
  color: #fff;
  text-shadow: 0 -1px 0 rgba(0, 0, 0, 0.25);
}
.datepicker td.active:hover,
.datepicker td.active:hover:hover,
.datepicker td.active:focus,
.datepicker td.active:hover:focus,
.datepicker td.active:active,
.datepicker td.active:hover:active,
.datepicker td.active.active,
.datepicker td.active:hover.active,
.datepicker td.active.disabled,
.datepicker td.active:hover.disabled,
.datepicker td.active[disabled],
.datepicker td.active:hover[disabled] {
  color: #ffffff;
  background-color: #0044cc;
  *background-color: #003bb3;
}
.datepicker td.active:active,
.datepicker td.active:hover:active,
.datepicker td.active.active,
.datepicker td.active:hover.active {
  background-color: #003399 \9;
}
.datepicker td span {
  display: block;
  width: 47px;
  height: 54px;
  line-height: 54px;
  float: left;
  margin: 2px;
  cursor: pointer;
  -webkit-border-radius: 4px;
  -moz-border-radius: 4px;
  border-radius: 4px;
}
.datepicker td span:hover {
  background: #eeeeee;
}
.datepicker td span.active {
  color: #ffffff;
  background-color: #006dcc;
  background-image: -moz-linear-gradient(top, #0088cc, #0044cc);
  background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#0088cc), to(#0044cc));
  background-image: -webkit-linear-gradient(top, #0088cc, #0044cc);
  background-image: -o-linear-gradient(top, #0088cc, #0044cc);
  background-image: linear-gradient(to bottom, #0088cc, #0044cc);
  background-repeat: repeat-x;
  filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#ff0088cc', endColorstr='#ff0044cc', GradientType=0);
  border-color: #0044cc #0044cc #002a80;
  border-color: rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.25);
  *background-color: #0044cc;
  /* Darken IE7 buttons by default so they stand out more given they won't have borders */

  filter: progid:DXImageTransform.Microsoft.gradient(enabled = false);
  color: #fff;
  text-shadow: 0 -1px 0 rgba(0, 0, 0, 0.25);
}
.datepicker td span.active:hover,
.datepicker td span.active:focus,
.datepicker td span.active:active,
.datepicker td span.active.active,
.datepicker td span.active.disabled,
.datepicker td span.active[disabled] {
  color: #ffffff;
  background-color: #0044cc;
  *background-color: #003bb3;
}
.datepicker td span.active:active,
.datepicker td span.active.active {
  background-color: #003399 \9;
}
.datepicker td span.old {
  color: #999999;
}
.datepicker th.switch {
  width: 145px;
}
.datepicker th.next,
.datepicker th.prev {
  font-size: 21px;
}
.datepicker thead tr:first-child th {
  cursor: pointer;
}
.datepicker thead tr:first-child th:hover {
  background: #eeeeee;
}
.input-append.date .add-on i,
.input-prepend.date .add-on i {
  display: block;
  cursor: pointer;
  width: 16px;
  height: 16px;
}
</style>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
<div class="container">
	<div class="row">
		 <form class="form-horizontal" method="POST" >
                <!-- Address form -->
                
            <h2 style="color:#00b1b1;">Update profile</h2></span><br>
             <hr style="color: #000000" />
           
         
                <!-- full-name input-->
                <div class="control-group">
                    <label class="control-label">Full Name</label>
                    <div class="controls">
                        <input id="name" name="name" type="text" placeholder="name"
                        class="input-xlarge">
                        <p class="help-block"></p>
                    </div>
                </div>
                <br>
                
    
            <div class="control-group">
                <label class="control-label">Gender</label>
                <div class="controls">
                     <input type= "radio" name = "gender" value="Male" />Male   
                    <input type="radio" name = "gender" value="Female" />Female <br/>
                </div>
            </div>
            <br>
            
    <!-- city input-->
                <div class="control-group">
                    <label class="control-label">Nationality</label>
                    <div class="controls">
                        <input id="nationality" name="nationality" type="text" placeholder="nationality" class="input-xlarge">
                        <p class="help-block"></p>
                    </div>
                </div>
                <br>
        
                <!-- country select -->
                <div class="control-group">
                    <label class="control-label">Faculty</label>
                    <div class="controls">
                        <select id="faculty" name="faculty" class="input-xlarge">
                            <option value="" selected="selected">(please select a faculty)</option>
                            <option value = "Engineering">Engineering</option>
                            <option value = "Science">Science</option>
                            <option value = "IT / Comp. Sci.">IT / Comp. Sci.</option>
                            <option value = "Arts">Arts</option>
                        </select>
                    </div>
                </div>
				<br>

                <!-- country select -->
                <div class="control-group">
                    <label class="control-label">Year</label>
                    <div class="controls">
                        <select id="year" name="year" class="input-xlarge">
                            <option value="" selected="selected">(please select a year)</option>
                            <option value = "1st">1st</option>
                            <option value = "2nd">2nd</option>
                            <option value = "3rd">3rd</option>
                            <option value = "4th">4th</option>
                            <option value = "5th+">5th+</option>
                        </select>
                    </div>
                </div>
				<br>
				
                <div class="control-group">
                    <label class="control-label">Field of study</label>
                    <div class="controls">
                        <input id="major" name="major" type="text" placeholder="Field of study" class="input-xlarge">
                        <p class="help-block"></p>
                    </div>
                </div>
                <br>

                <div class="control-group">
                    <label class="control-label">Degree Type</label>
                    <div class="controls">
                <input type= "radio" name = "degree" value="Undergrad" />Undergrad
                <input type="radio" name = "degree" value="Postgrad" />Postgrad<br/>
                <input type="radio" name = "degree" value="PhD Student" />PhD Student<br/><br>
                </div>
                <br>
                
                </div>
                
                 <input type="submit" value="Update" /><br>
                  <hr style="color: #000000" />

        </form>
        </div>
        </div>
<jsp:include page="footer.jsp" />
</body>
</html>