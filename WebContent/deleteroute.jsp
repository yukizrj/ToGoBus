<script>  
function validate()  
{  
var num = /^\d{10}$/;
var r = document.forms["myform"]["route_id"].value; 

if(isNaN(r)){
	alert("Please enter number");
	return false;
}
}
</script>

<jsp:include page="header.jsp"/>
<jsp:include page="sidebar.jsp"/> 
<%
	String id=request.getParameter("route_id");
%>
<div class="mymainWrapper col-xs-12">
	<div class="centerformWrapper col-sm-6 col-xs-12">
		<div class="centertitle row col-xs-12">Delete Route</div>
		<div class="errordiv col-xs-10">
			<%
				if (request.getParameter("msg") != null) {
			%>
			<h4><%=request.getParameter("msg")%></h4>
			<%
				}
			%>
		</div>
		<div class="centerform col-xs-12">
			<form name="myform" action="DeleteRouteServlet" onsubmit="return validate();">
				<div class="form-group">
					<label for="route_id">Enter Route ID</label> <input type="text"
						name="route_id" class="form-control" value="<%=id%>" required/>
				</div>
				<div class="form-group">
					<input type="submit" class="btn btn-primary" value="Delete" /> 
				</div>
			</form>
		</div>
	</div>
</div>
<jsp:include page="footer.jsp"/>	