package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.Booking;
import com.db.DButil;

public class BookingDao {
	public static Booking fullinfo(Booking book){
		Connection con=DButil.getConnection();
		ResultSet rs=null;
		PreparedStatement stat=null;
		try {
			stat=con.prepareStatement("select source, destination, plate, departure_time, arrival_time, datetime, price from route join schedule on schedule.route_id=route.route_id where schedule.schedule_id=?");
			stat.setInt(1, book.getSchedule_id());
			rs=stat.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(rs.next()){
				book.setDestination(rs.getString("destination"));
				book.setSource(rs.getString("source"));
				book.setArrival_time(rs.getString("arrival_time"));
				book.setDatetime(rs.getDate("datetime"));
				book.setDeparture_time(rs.getString("departure_time"));
				book.setPrice(rs.getInt("price"));
				book.setPlate(rs.getInt("plate"));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DButil.closeConnection(stat, con);
		}
		System.out.println("fill in booking"+book.getDestination()+" "+book.getName());
		return book;
		
	}
	public static void insert(Booking book){
		Connection con=DButil.getConnection();
		PreparedStatement stat=null;
		try {
			stat=con.prepareStatement("insert into booking values(?,?,?,?,?,?,?,?,?,?,?,?)");
			stat.setInt(3, book.getSchedule_id());
			//System.out.println(book.getSchedule_id());
			stat.setString(1, book.getName());
			stat.setString(2, book.getEmail());
			stat.setString(4, book.getSource());
			stat.setString(5, book.getDestination());
			stat.setString(6, book.getDeparture_time());
			stat.setString(7, book.getArrival_time());
			stat.setInt(8, book.getPrice());
			stat.setDate(9, book.getDatetime());
			stat.setInt(10,book.getPlate());
			stat.setInt(11, book.getPassnum());
			stat.setString(12, book.getPhone());
			stat.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DButil.closeConnection(stat, con);
		}
		
	}
	public static int getSeat(int id, String departure){
		int seatleft=0;
		Connection con=DButil.getConnection();
		PreparedStatement stat=null;
		ResultSet rss=null;
		try {
			stat=con.prepareStatement("select seat_left from schedule where schedule_id=? and departure_time=?");
			stat.setInt(1, id);
			stat.setString(2, departure);
			rss=stat.executeQuery();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			while(rss.next()){
				seatleft=rss.getInt("seat_left");
			}
			rss.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return seatleft;
	}
		
	public static void setSeat(int seats, int id, String departure){
		Connection con=DButil.getConnection();
		PreparedStatement stat=null;
		try {
			stat=con.prepareStatement("update schedule set schedule.seat_left=? where schedule_id=? and departure_time=?");
			stat.setInt(1, seats);
			stat.setInt(2, id);
			stat.setString(3, departure); 
			stat.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DButil.closeConnection(stat, con);
	}
	
	public static ResultSet showbooking(Booking book){
		Connection con=DButil.getConnection();
		ResultSet rs=null;
		try {
			PreparedStatement stat=con.prepareStatement("select * from booking where booking.name=?");
			stat.setString(1, book.getName());
			rs=stat.executeQuery();
		} catch (SQLException e) {
			System.out.println("select booking information fail");
			e.printStackTrace();
		}
		/*try {
			if(!rs.next()){
				System.out.println("result null in BookingDao");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return rs;
		
	}
	public static ResultSet showB(){
		Connection con=DButil.getConnection();
		ResultSet rs=null;
		try {
			PreparedStatement stat=con.prepareStatement("select * from booking");
			rs=stat.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}
}
