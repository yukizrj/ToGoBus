package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.bean.Schedule;
import com.db.DButil;

public class ScheduleDao {
	public static ResultSet ShowResult(String date, String from, String to, int passnum){
		java.util.Date d = null;
		ResultSet rs=null;
		try {
			d = new SimpleDateFormat("MM/dd/yyyy").parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date sqldate=new java.sql.Date(d.getTime());
		
		Connection con=DButil.getConnection();
		try {
			PreparedStatement stat=con.prepareStatement("select * from schedule full outer join route on schedule.route_id = route.route_id where schedule.datetime=? and route.source=? and route.destination=? and schedule.seat_left>=?");
			stat.setDate(1, sqldate);
			stat.setString(2, from);
			stat.setString(3, to);
			stat.setInt(4, passnum);
			rs=stat.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}
	public static ResultSet showAll(){
		Connection con=DButil.getConnection();
		ResultSet rs=null;
		try {
			PreparedStatement stat=con.prepareStatement("select * from schedule full outer join route on schedule.route_id = route.route_id");
			rs=stat.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public static ResultSet showS(){
		Connection con=DButil.getConnection();
		ResultSet rs=null;
		try {
			PreparedStatement stat=con.prepareStatement("select * from schedule");
			rs=stat.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}
	public static void addnewschedule(Schedule schedule){
		java.util.Date d = null;
		try {
			d = new SimpleDateFormat("MM/dd/yyyy").parse(schedule.getDate());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date sqldate=new java.sql.Date(d.getTime());
		Connection con=DButil.getConnection();
		PreparedStatement stat=null;
		try {
			stat=con.prepareStatement("insert into schedule values(?,?,?,?,?,?,?,?)");
			stat.setInt(1, schedule.getSchedule_id());
			stat.setInt(2, schedule.getPlate());
			stat.setInt(3, schedule.getRoute_id());
			stat.setDate(4, sqldate);
			stat.setString(5, schedule.getDeparture_time());
			stat.setString(6, schedule.getArrival_time());
			stat.setInt(7, schedule.getSeat_left());
			stat.setInt(8, schedule.getPrice());
			stat.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DButil.closeConnection(stat, con);
		}
		
	}
	
	public static int deleteschedule(int id){
		int rowd=1;
		PreparedStatement stat = null;
			Connection con=DButil.getConnection();
			try {
				stat=con.prepareStatement("delete from schedule where schedule_id=?");
				stat.setInt(1, id);
				rowd=stat.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DButil.closeConnection(stat, con);
			}
			return rowd;
	
	}

}
