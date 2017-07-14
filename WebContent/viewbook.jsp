<jsp:include page="header.jsp"/>
<jsp:include page="sidebar.jsp"/>
<%@page import="java.sql.ResultSet" %>
<%@page import="com.dao.BookingDao" %>
<% 
/* ResultSet rs=null;
rs=ScheduleDao.showAll(); */
ResultSet rss=BookingDao.showB();

%>
<div class="mymainWrapper col-xs-12">
	<div class="tableWrapper col-xs-12">
		<div class="centertitle row col-xs-12">
			Booking
		</div>
		<div class="tab-content col-xs-12">
			<table class="col-xs-12 table table-bordered">
				<tr>
					<td>Passanger name</td>
					<td>Passanger emial</td>
					<td>Schedule ID</td>
					<td>Passanger number</td>
					<td>Date</td>
					<td>DepartureTime</td>
					<td>ArrivalTime</td>
					
				</tr>
				<%
					try{
						while(rss.next()){
				%>
				<tr>
				<td><%=rss.getString("name")%></td>
				<td><%=rss.getString("email")%></td>
				<td><%=rss.getInt("schedule_id")%></td>
				<td><%=rss.getInt("passnum")%></td>
				<td><%=rss.getDate("datetime")%></td>
				<td><%=rss.getString("departure_time")%></td>
				<td><%=rss.getString("arrival_time")%></td>
				</tr>
				<%
						}
						rss.close();
					} catch(Exception e){
						System.out.print("get booking detail error.");
					}
				%>
			</table>
		</div>
	</div>
</div>
<jsp:include page="footer.jsp"/>