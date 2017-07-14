package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.Route;
import com.db.DButil;

public class RouteDao {
	public static void addnewroute(Route route){
		boolean isnull=checkroute(route);
		PreparedStatement stat = null;
		if(isnull){
			Connection con=DButil.getConnection();
			try {
				stat=con.prepareStatement("insert into route values(?,?,?)");
				stat.setInt(1, route.getRoute_id());
				stat.setString(2, route.getSource());
				stat.setString(3, route.getDestination());
				stat.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DButil.closeConnection(stat, con);
			}
			
		}
		
		
	}
	
	public static ResultSet showR(){
		Connection con=DButil.getConnection();
		ResultSet rs=null;
		try {
			PreparedStatement stat=con.prepareStatement("select * from route");
			rs=stat.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}
	
	public static int deleteroute(int id){
		int rowd=1;
		PreparedStatement stat = null;
			Connection con=DButil.getConnection();
			try {
				stat=con.prepareStatement("delete from route where route_id=?");
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
	public static int deleterouteschedule(int id){
		int rowd=1;
		PreparedStatement stat = null;
			Connection con=DButil.getConnection();
			try {
				stat=con.prepareStatement("delete from schedule where route_id=?");
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
	static boolean checkroute(Route route){
		boolean isnull=true;
		Connection con=DButil.getConnection();
		ResultSet rs=null;
		PreparedStatement stat = null;
		try {
			stat = con.prepareStatement("select * from route where route_id=?");
			stat.setInt(1, route.getRoute_id());
			rs=stat.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(rs.next()){
				isnull=false;
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DButil.closeConnection(stat, con);
		return isnull;
	}
}
