<%@page import="java.sql.ResultSet;" %>
<jsp:include page="header.jsp"/>
<jsp:include page="usersidebar.jsp"/>

<div class="mymainWrapper col-xs-12">
	<div class="tableWrapper col-xs-12">
		<div class="centertitle row col-xs-12">
			Search Result
		</div>
		<div class="tab-content col-xs-12">
			<table class="col-xs-12 table table-bordered">
				<tr>
					<td>Bus Model</td>
					<td>Departure Time</td>
					<td>Arrival Time</td>
					<td>Seats Left</td>
					<td>Price</td>
				</tr>
				<%
					ResultSet rs=(ResultSet) request.getAttribute("resultset");
					try{
						while(rs.next()){
				%>
				<tr>
				<td><%=rs.getString("plate")%></td>
				<td><%=rs.getString("departure_time")%></td>
				<td><%=rs.getString("arrival_time")%></td>
				<td><%=rs.getInt("seat_left")%></td>
				<td><%=rs.getString("price")%></td>
				<td><a href="bookticket.jsp?schedule_id=<%=rs.getInt("schedule_id")%>">select</a></td>
				</tr>
				<%
						}
						rs.close();
					} catch(Exception e){
						System.out.print("get result error.");
					}
				%>
			</table>
		</div>
	</div>
</div>
<jsp:include page="footer.jsp"/>	