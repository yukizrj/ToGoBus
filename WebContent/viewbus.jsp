<jsp:include page="header.jsp"/>
<jsp:include page="sidebar.jsp"/>
<%@page import="java.sql.ResultSet" %>
<%@page import="com.dao.ScheduleDao" %>
<%@page import="com.dao.RouteDao" %>
<%@page import="com.dao.BusDao" %>
<% 
/* ResultSet rs=null;
rs=ScheduleDao.showAll(); */
ResultSet rss=ScheduleDao.showS();
ResultSet rsr=RouteDao.showR();
ResultSet rsb=BusDao.showB();
%>
<div class="mymainWrapper col-xs-12">
	<div class="tableWrapper col-xs-12">
		<div class="centertitle row col-xs-12">
			Schedule
		</div>
		<div class="tab-content col-xs-12">
			<table class="col-xs-12 table table-bordered">
				<tr>
					<td>ScheduleID</td>
					<td>BusPlate</td>
					<td>RouteID</td>
					<td>Date</td>
					<td>DepartureTime</td>
					<td>ArrivalTime</td>
					<td>Seat Left</td>
					<td>Price</td>
					
				</tr>
				<%
					try{
						while(rss.next()){
				%>
				<tr>
				<td><%=rss.getInt("schedule_id")%></td>
				<td><%=rss.getInt("plate")%></td>
				<td><%=rss.getInt("route_id")%></td>
				<td><%=rss.getDate("datetime")%></td>
				<td><%=rss.getString("departure_time")%></td>
				<td><%=rss.getString("arrival_time")%></td>
				<td><%=rss.getInt("seat_left")%></td>
				<td><%=rss.getString("price")%></td>
				<td><a href="deleteschedule.jsp?schedule_id=<%=rss.getInt("schedule_id")%>">delete</a></td>
				</tr>
				<%
						}
						rss.close();
					} catch(Exception e){
						System.out.print("get schedule detail error.");
					}
				%>
			</table>
		</div>
	</div>
	<div class="tableWrapper2 col-xs-12">
		<div class="centertitle row col-xs-12">
			Route
		</div>
		<div class="tab-content col-xs-12">
			<table class="col-xs-12 table table-bordered">
				<tr>
					<td>RouteID</td>
					<td>From</td>
					<td>To</td>
					
				</tr>
				<%
					try{
						while(rsr.next()){
				%>
				<tr>
				<td><%=rsr.getInt("route_id")%></td>
				<td><%=rsr.getString("source")%></td>
				<td><%=rsr.getString("destination")%></td>
				<td><a href="deleteroute.jsp?route_id=<%=rsr.getInt("route_id")%>">delete</a></td>
				</tr>
				<%
						}
						rsr.close();
					} catch(Exception e){
						System.out.print("get route detail error.");
					}
				%>
			</table>
		</div>
	</div>
	<div class="tableWrapper3 col-xs-12">
		<div class="centertitle row col-xs-12">
			Bus
		</div>
		<div class="tab-content col-xs-12">
			<table class="col-xs-12 table table-bordered">
				<tr>
					<td>BusPlate</td>
					<td>Model</td>
					<td>Capacity</td>
					
				</tr>
				<%
					try{
						while(rsb.next()){
				%>
				<tr>
				<td><%=rsb.getInt("plate")%></td>
				<td><%=rsb.getString("model")%></td>
				<td><%=rsb.getInt("capacity")%></td>
				</tr>
				<%
						}
						rss.close();
					} catch(Exception e){
						System.out.print("get bus detail error.");
					}
				%>
			</table>
		</div>
	</div>

</div>
<jsp:include page="footer.jsp"/>