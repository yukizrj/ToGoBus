<script type="text/javascript">
 function openPage(pageURL)
 {
 window.location.href = pageURL;
 }
</script>
<%@page import="java.sql.ResultSet" %>
<%@page import="com.bean.Booking" %>
<%@page import="com.dao.BookingDao" %>

<jsp:include page="header.jsp"/>
<jsp:include page="usersidebar.jsp"/>

<div class="mymainWrapper col-xs-12">
	<div class="tableWrapper col-xs-12">
		<div class="centertitle row col-xs-12">
			Your Receipt
		</div>
		<div class="tableContent col-xs-9">
			<table class="col-xs-12  table table-bordered">
				<tr>
				<tr>
					<td>Name</td>
					<td>Email</td>
					<td>Phone</td>
					<td>Bus Plate</td>
					<td>From</td>
					<td>To</td>
					<td>Departure Date</td>
					<td>Departure Time</td>
					<td>Arrival Time</td>
					<td>Tickets You Book</td>
					<td>Total price (USD)</td>
				</tr>
				<%
					ResultSet rs = (ResultSet)request.getAttribute("result");
				try{
					
					while(rs.next()){%>
				<tr>
					<td><%=rs.getString("name") %></td>
					<td><%=rs.getString("email") %></td>
					<td><%=rs.getString("phone") %></td>
					<td><%=rs.getInt("plate") %></td>
					<td><%=rs.getString("source") %></td>
					<td><%=rs.getString("destination") %></td>
					<td><%=rs.getDate("datetime") %></td>
					<td><%=rs.getString("departure_time") %></td>
					<td><%=rs.getString("arrival_time") %></td>
					<td><%=rs.getInt("passnum") %></td>
					<td><%=rs.getInt("passnum")*rs.getInt("price") %></td>
					<%-- <%
					int total=rs.getInt("passnum")*rs.getInt("price");
					String subject = "confirm bus booking";
						String body = "Thank you for booking ticket, here is your information: \n"+"your name: "+rs.getString("name")+"\n"+"Bus plate: "+rs.getInt("plate")+"\n"+"departure time: "+rs.getString("departure_time")+"\n"+"Tickets number: "+rs.getInt("passnum")+"\n"+"Total price: "+total;
				String sendBox = "rujiezheng124@gmail.com";
				String password = "88888888";
					new SendEmail(rs.getString("email"), subject, body, sendBox, password);
				%> --%>
				</tr>
				<%
						}
						rs.close();
					} catch(Exception e){
						System.out.print("get booking detail error.");
					}
				%>
			</table>
		</div>
		<div class="form-group">
			<button class="btn btn-success" onclick="javascript:window.print()"><span>&nbsp;&nbsp;</span>Print</button>
			<button class="btn btn-success" onclick="openPage('index.jsp')"><span>&nbsp;&nbsp;</span>Home</button>
		</div>
	</div>
</div>
<jsp:include page="footer.jsp"/>