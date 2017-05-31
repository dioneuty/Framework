package com.hb.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDB {
	private Connection conn;
	private String driver;
	private String url;
	
	private MyDB(){}
	
	public Connection getConnection() throws ClassNotFoundException, SQLException{
			if(conn==null||conn.isClosed()){
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott","tiger");
			}
		return conn;
		
	}
	
}
