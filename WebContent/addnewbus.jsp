<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/smoothness/jquery-ui.css" rel="stylesheet" type="text/css"/>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>
<script>
  $(document).ready(function() {
    $("#datepicker").datepicker({minDate:'0'});
  });
</script>

<script>  
function validate()  
{  
var num = /^\d{10}$/;
var s = document.forms["myform"]["schedule_id"].value; 
var r = document.forms["myform"]["route_id"].value; 
var p = document.forms["myform"]["plate"].value; 
var pp = document.forms["myform"]["price"].value;
var c = document.forms["myform"]["capacity"].value;
if(isNaN(s)){
	alert("Please schedule number");
	return false;
}
if(isNaN(r)){
	alert("Please route number");
	return false;
}
if(isNaN(p)){
	alert("Please plate number");
	return false;
}
if(isNaN(pp)){
	alert("Please price number");
	return false;
}
if(isNaN(c)){
	alert("Please capacity number");
	return false;
}
}

</script>  
<jsp:include page="header.jsp"/>
<jsp:include page="sidebar.jsp"/>

<div class="form-box col-sm-offset-4 col-sm-4 col-xs-12">
 		<div class="form-top">
  		<div class="form-top-left">
  			<div class="formtitle row col-xs-12">Add New Schedule</div>
  		</div>
  		<div class="form-top-right">
  			<i class="fa fa-pencil"></i>
  		</div>
      </div>
      <div class="form-bottom">
 <form name="myform" action="AddBusServlet" method="post" onsubmit="return validate();">
 	<div class="form-group">
 		<label style="color: black" for="schedule_id">Enter Schedule ID</label>
     	<input type="text" name="schedule_id" placeholder="Schedule_id" class="form-control" required>
     </div>
     <div class="form-group">
     	<label style="color: black" for="plate">Enter Bus Plate</label>
     	<input type="text" name="plate" placeholder="Bus Plate" class="form-control" required>
     </div>
     <div class="form-group">
     	<label style="color: black" for="model">Enter Bus Model</label>
     	<input type="text" name="model" placeholder="Bus Model" class="form-control" required>
     </div>
     <div class="form-group">
     	<label style="color: black" for="capacity">Enter Bus Capacity</label>
     	<input type="text" name="capacity" placeholder="Bus Capacity" class="form-control" required>
     </div>
     <div class="form-group">
     	<label style="color: black" for="route_id">Enter Route ID</label>
     	<input type="text" name="route_id" placeholder="Route ID" class="form-control" required>
     </div>
      <div class="form-group">
     	<label style="color: black" for="date">Enter Date</label>
     	<input type="text" name="date" id="datepicker" placeholder="Date" class="form-control" required>
     </div>
      <div class="form-group">
     	<label style="color: black" for="departure_time">Enter Departure Time</label>
     	<!-- <input type="text" name="departure_time" placeholder="Departure Time" class="form-control" required> -->
     	<select name="departure_time" class="form-control">
     		<option value="7:00 am">7:00 am</option>
     		<option value="8:00 am">8:00 am</option>
     		<option value="9:00 am"> 9:00 am</option>
     		<option value="10:00 am">10:00 am</option>
     		<option value="11:00 am">11:00 am</option>
     		<option value="12:00 pm">12:00 pm</option>
     		<option value="13:00 pm">13:00 pm</option>
     		<option value="14:00 pm">14:00 pm</option>
     		<option value="15:00 pm">15:00 pm</option>
     		<option value="16:00 pm">16:00 pm</option>
     		<option value="17:00 pm">17:00 pm</option>
     	</select>
     </div>
      <div class="form-group">
     	<label style="color: black" for="arrival_time">Enter Arrival Time</label>
     	<input type="text" name="arrival_time" placeholder="Arrival Time" class="form-control" required>
     	<!-- <select name="arrival_time" class="form-control">
     		<option value="8:00 am">8:00 am</option>
     		<option value="9:00 am"> 9:00 am</option>
     		<option value="10:00 am">10:00 am</option>
     		<option value="11:00 am">11:00 am</option>
     		<option value="12:00 pm">12:00 pm</option>
     		<option value="13:00 pm">13:00 pm</option>
     		<option value="14:00 pm">14:00 pm</option>
     		<option value="15:00 pm">15:00 pm</option>
     		<option value="16:00 pm">16:00 pm</option>
     		<option value="17:00 pm">17:00 pm</option>
     		<option value="18:00 pm">18:00 pm</option>
     		<option value="19:00 pm">19:00 pm</option>
     		<option value="20:00 pm">20:00 pm</option>
     		
     	</select> -->
     </div>
      <div class="form-group">
     	<label style="color: black" for="price">Enter Price</label>
     	<input type="text" name="price" placeholder="Price" class="form-control" required>
     </div>
     <button type="submit" class="btn">Add Schedule</button>
 </form>
</div>
 	</div>
	
<jsp:include page="footer.jsp"/>