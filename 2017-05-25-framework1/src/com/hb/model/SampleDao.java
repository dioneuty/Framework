package com.hb.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SampleDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public SampleDao() throws ClassNotFoundException, SQLException {
		Connection myconn = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		myconn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott","tiger");
		conn = myconn;
	}
	
	public SampleDao(boolean auto) throws ClassNotFoundException, SQLException{
		Connection myconn = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		myconn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott","tiger");
		myconn.setAutoCommit(auto);
		conn = myconn;
	}
	
	public void back() throws SQLException{
		conn.rollback();
		closeAll();
	}
	
	public void closeAll() throws SQLException{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(conn!=null) conn.close();
	}
	
	public List<Map<String,Object>> selectAll() throws SQLException{
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		pstmt = conn.prepareStatement("select * from guest01");
		rs =pstmt.executeQuery();
		while(rs.next()){
			//JSON 객체와 흡사
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("sabun",rs.getInt("sabun"));
			map.put("name", rs.getString("name"));
			map.put("nalja", rs.getDate("nalja"));
			map.put("pay",rs.getInt("pay"));
			list.add(map);
		}
		//closeAll();
		return list;
	}
	
	public Map<String,Object> selectOne(int sabun) throws SQLException{
		Map<String,Object> map = new HashMap<>();
		pstmt = conn.prepareStatement("select * from guest01 where sabun=?");
		pstmt.setInt(1, sabun);
		rs = pstmt.executeQuery();
		if(rs.next()){
			map.put("sabun",rs.getInt("sabun"));
			map.put("name", rs.getString("name"));
			map.put("nalja", rs.getDate("nalja"));
			map.put("pay",rs.getInt("pay"));
		}
		//closeAll();
		return map;
	}
	
	public int insertOne(int sabun, String name, int pay) throws SQLException{
		int result = 0;
		pstmt = conn.prepareStatement("insert into guest01 values(?,?,sysdate,?)");
		pstmt.setInt(1, sabun);
		pstmt.setString(2, name);
		pstmt.setInt(3, pay);
		result = pstmt.executeUpdate();
		//closeAll();
		return result;
	}
}
