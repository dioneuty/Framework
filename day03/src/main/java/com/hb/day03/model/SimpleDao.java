package com.hb.day03.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SimpleDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public SimpleDao(){
		String url = "jdbc:h2:tcp://localhost/~/test";
		String user = "sa";
		String password = "";
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void close() throws SQLException {
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(conn!=null) conn.close();
	}
	
	public List selectAll() throws SQLException {
		String sql = "select * from simple02";
		List<SimpleVo> list = new ArrayList<>();
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()){
			SimpleVo bean = new SimpleVo();			
			bean.setSabun(rs.getInt("sabun"));
			bean.setName(rs.getString("name"));
			bean.setNalja(rs.getString("nalja"));
			bean.setPay(rs.getInt("pay"));
			list.add(bean);
		}
		close();
		
		return list;
	}

	public int insertOne(String name, String nalja, int pay) throws SQLException {
		String sql = "insert into simple02 (name,nalja,pay)";
		sql += " values (?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setString(2, nalja);
		pstmt.setInt(3, pay);
		int result = pstmt.executeUpdate();
		close();
		return result;
	}
	
}
