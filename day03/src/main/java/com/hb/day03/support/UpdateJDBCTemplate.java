package com.hb.day03.support;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateJDBCTemplate {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public UpdateJDBCTemplate() {
		String url="jdbc:h2:tcp://localhost/~/test";
		String user="sa";
		String password="";
		try {
			Class.forName("org.h2.Driver");
			conn=DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int executeUpdate(String sql,Object[] objs) throws SQLException{
		PreparedStatement pstmt = conn.prepareStatement(sql);
		for(int i = 0; i < objs.length; i++){
			pstmt.setObject(i+1, objs[i]);
		}
		
		int result = pstmt.executeUpdate();
		return result;
	}
	
	private void close() throws SQLException {
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
		if(conn!=null)conn.close();
	}
	
	public Object executeQuery(String sql, RowMapper mapper) throws SQLException{
		return executeQuery(sql, new Object[]{}, mapper);
	}
	
	public Object executeQuery(String sql, Object[] objs, RowMapper mapper) throws SQLException {
		pstmt = conn.prepareStatement(sql);
		for(int i = 0; i<objs.length; i++){
			pstmt.setObject(i+1, objs[i]);
		}
		rs = pstmt.executeQuery();
		Object obj = mapper.mapRow(rs);
		close();
		return obj;
	}
	
}
