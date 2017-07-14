package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.Admin;
import com.db.DButil;

public class AdminDao {
	public static boolean isValidate(Admin admin){
		ResultSet rs=null;
		boolean isValid=false;
		Connection con=DButil.getConnection();
		try {
			PreparedStatement stat=con.prepareStatement("select * from admin where username=? and password=?");
			stat.setString(1, admin.getUsername());
			stat.setString(2, admin.getPassword());
			rs=stat.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(rs.next()){
				isValid=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return isValid;
		}
		
	}

}
