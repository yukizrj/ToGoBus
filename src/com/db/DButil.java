package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DButil {
	private static final String DRIVER="oracle.jdbc.driver.OracleDriver";
	private static final String URL="jdbc:oracle:thin:@localhost:1522:xe";
	private static final String UNAME="ZRJ";
	private static final String PASSWORD="123456";
	static{
			try {
				Class.forName(DRIVER);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public static Connection getConnection(){
		Connection con=null;
		try {
			con=DriverManager.getConnection(URL,UNAME,PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public static void closeConnection(PreparedStatement stat, Connection con){
		
			try {
				if(stat!=null){
					stat.close();
				}
				if(con!=null){
					con.close();
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
}
