package com.hb.day03.support;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.hb.day03.model.SimpleVo;

public abstract class UpdateJDBC2 {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public UpdateJDBC2() {
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
	public abstract Object mapper(ResultSet rs) throws SQLException;
	
	
	private void close() throws SQLException {
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
		if(conn!=null)conn.close();
	}
	
	public Object executeQuery(String sql) throws SQLException{
		return executeQuery(sql, new Object[]{});
	}
	
	public Object executeQuery(String sql, Object[] objs) throws SQLException {
		pstmt = conn.prepareStatement(sql);
		for(int i = 0; i<objs.length; i++){
			pstmt.setObject(i+1, objs[i]);
		}
		rs = pstmt.executeQuery();
		Object obj = mapper(rs);
		close();
		return obj;
	}
}
