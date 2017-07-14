<script>  
function validate()  
{  
var s = document.forms["myform"]["source"].value;
var d = document.forms["myform"]["destination"].value;
if(/^[A-Za-z\s]+$/.test(s)===false || /^[A-Za-z\s]+$/.test(d)===false){
	alert("Please enter correct location")
	return false;
}
if(s==d){
	alert("departure city and destination city cannot be same");
	return false;
}

var r = document.forms["myform"]["route_id"].value; 
if(isNaN(r)){
	alert("Please enter number");
	return false;
}
}

</script> 
<jsp:include page="header.jsp"/> 
<jsp:include page="sidebar.jsp"/>

		
		<div class="errordiv col-xs-10">
			<%
				if (request.getParameter("msg") != null) {
			%>
			<h4><%=request.getParameter("msg")%></h4>
			<%
				}
			%>
		</div>
		
		<div class="form-box col-sm-offset-4 col-sm-4 col-xs-12">
 		<div class="form-top">
  		<div class="form-top-left">
  			<div class="formtitle row col-xs-12">Add New Route</div>
  		</div>
  		<div class="form-top-right">
  			<i class="fa fa-pencil"></i>
  		</div>
      </div>
      <div class="form-bottom">
 <form name="myform" action="AddRouteServlet" method="post" onsubmit="return validate();">
 	<div class="form-group">
 		<label style="color: black" for="route_id">Enter Route ID</label>
     	<input type="text" name="route_id" placeholder="Route ID" class="form-control" required>
     </div>
     <div class="form-group">
 		<label style="color: black" for="source">Enter From</label>
     	<input type="text" name="source" placeholder="From" class="form-control" required>
     </div>
     <div class="form-group">
 		<label style="color: black" for="destination">Enter To</label>
     	<input type="text" name="destination" placeholder="To" class="form-control" required>
     </div>
    <button type="submit" class="btn">Add Schedule</button>
 </form>
</div>
 	</div>
		
				
<jsp:include page="footer.jsp"/>