<jsp:include page="header.jsp"/>
<jsp:include page="sidebar.jsp"/>
<div class="mymainWrapper" col-xs-12>
	<div class="rightWrapper col-md-3 col-sm-12">
	<div class="centertitle row-col-xs-12">Admin Login</div>
	<div class="col-xs-12">
	<form action="LoginServlet">
		<div class="from-group col-xs-10">
			<label for="username">Username</label>
			<input type="text" class="form-control" name="username"/>
		</div>
		<div class="from-group col-xs-10">
			<label for="password">Password</label>
			<input type="text" class="form-control" name="password"/>
		</div>
		<div class="from-group col-xs-10" >
			<button type="submit" class="btn btn-warning">Login</button>
		</div>
	</form>
	</div>
</div>
</div>