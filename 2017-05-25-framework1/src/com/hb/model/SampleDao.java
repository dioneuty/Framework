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
		Class.forName("org.h2.Driver");
		myconn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa","");
		conn = myconn;
	}
	
	public List<Map<String,Object>> selectAll() throws SQLException{
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		pstmt = conn.prepareStatement("select * from sample01");
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
		closeAll();
		return list;
	}
	public void closeAll() throws SQLException{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(conn!=null) conn.close();
	}
}
