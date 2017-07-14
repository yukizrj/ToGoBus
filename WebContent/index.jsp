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
var s = document.forms["myform"]["from"].value;
console.log(s);
var d = document.forms["myform"]["to"].value;
console.log(d);
if(/^[A-Za-z\s]+$/.test(s)===false || /^[A-Za-z\s]+$/.test(d)===false){
	alert("Please enter correct location")
	return false;
}
if(s==d){
	alert("departure city and destination city cannot be same");
	return false;
}
}

</script> 

<jsp:include page="header.jsp"/>
<jsp:include page="usersidebar.jsp"/>


	<div  class="errordiv col-xs-10">
	<%
		if (request.getParameter("msg") != null) {
	%>
	<h4 style="color:#ffff22;"><%=request.getParameter("msg")%></h4>
	<%
		}
	%>
	</div>	
	<div class="form-box col-sm-offset-2 col-sm-6 col-xs-12">
 		<div class="form-top">
  		<div class="form-top-left">
  			<div class="formtitle row col-xs-12" style="color: black">Search Ticket</div>
  		</div>
  		<div class="form-top-right">
  			<i class="fa fa-pencil"></i>
  		</div>
      </div>
      <div class="form-bottom">
 <form name="myform" action="SearchBusServlet" method="post" onsubmit="return validate();">
 	<div class="form-group">
 		<label style="color: black" for="from">From</label>
     	<input type="text" name="from" id="from" placeholder="From" class="form-control" required>
     </div>
     <div class="form-group">
 		<label style="color: black"for="to">To</label>
     	<input type="text" name="to" id="to" placeholder="To" class="form-control" required>
     </div>
     <div class="form-group col-sm-6 col-xs-12">
 		<label for="date" style="color: black">Date</label>
     	<input type="text" name="date" id="datepicker" placeholder="Select date" class="form-control" required>
     </div>
     <div class="form-group col-sm-6 col-xs-12">
 		<label for="passanger" style="color: black">Passanger</label>
     	<input type="number" name="passanger" min="1" max="6" value="1" class="form-control">
     </div>
     
    <button type="submit" class="btn">Search</button>
 </form>
 </div>
 </div>


<jsp:include page="footer.jsp"/>
