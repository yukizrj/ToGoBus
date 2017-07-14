<script>  
function validateemail()  
{  
var x = document.forms["myform"]["email"].value; 
var y = document.forms["myform"]["name"].value;
var atposition=x.indexOf("@");  
var dotposition=x.lastIndexOf(".");  
if (atposition<1 || dotposition<atposition+2 || dotposition+2>=x.length){  
  alert("Please enter a valid e-mail address");  
  return false;  
  } 
if(/^[A-Za-z\s]+$/.test(y)===false){
	alert("Please enter your correct name");
	return false;
}

}

</script>  
<jsp:include page="header.jsp"/>
<jsp:include page="usersidebar.jsp"/>
<%
	String id=request.getParameter("schedule_id");
%>
				
				<div class="form-box col-sm-offset-4 col-sm-4 col-xs-12">
 		<div class="form-top">
  		<div class="form-top-left">
  			<div class="formtitle row col-xs-12">Your information</div>
  		</div>
  		<div class="form-top-right">
  			<i class="fa fa-pencil"></i>
  		</div>
      </div>
      <div class="form-bottom">
 <form name="myform" action="BookTicketServlet" onsubmit="return validateemail();">
 	<div class="form-group">
 		<label style="color: black" for="name">Enter Name</label>
     	<input type="text" name="name" placeholder="Your Name" class="form-control" required>
     </div>
    <div class="form-group">
 		<label style="color: black" for="email">Enter Email</label>
     	<input type="text" name="email" placeholder="Your Email" class="form-control" required>
     </div>
     <div class="form-group">
 		<label style="color: black" for="phone">Enter Phone</label>
     	<input type="tel" pattern="^\d{10}$" name="phone" placeholder="Your phone" class="form-control" required>
     </div>
     <input type="hidden" name="schedule_id" value="<%=id%>"/>
    <button type="submit" class="btn">Confirm</button>
 </form>
</div>
 	</div>
				

<jsp:include page="footer.jsp"/>

