package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.Bus;
import com.db.DButil;

public class BusDao {
	
	public static ResultSet showB(){
		Connection con=DButil.getConnection();
		ResultSet rs=null;
		try {
			PreparedStatement stat=con.prepareStatement("select * from bus");
			rs=stat.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}
	
	public static void addnewbus(Bus bus){
		boolean isnull=checkbus(bus);
		PreparedStatement stat = null;
		if(isnull){
			Connection con=DButil.getConnection();
			try {
				stat=con.prepareStatement("insert into bus values(?,?,?,?)");
				stat.setInt(1, bus.getPlate());
				stat.setString(2, bus.getModel());
				stat.setInt(3, bus.getCapacity());
				stat.setInt(4, bus.getRoute_id());
				stat.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DButil.closeConnection(stat, con);
			}
			
		}
		
		
	}
	static boolean checkbus(Bus bus){
		boolean isnull=true;
		Connection con=DButil.getConnection();
		ResultSet rs=null;
		PreparedStatement stat = null;
		try {
			stat = con.prepareStatement("select * from bus where plate=?");
			stat.setInt(1, bus.getPlate());
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
