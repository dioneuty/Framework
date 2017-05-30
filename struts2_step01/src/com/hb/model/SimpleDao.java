package com.hb.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hb.util.MyOracle;

public class SimpleDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public List selectAll() throws SQLException{
		String sql = "select * from simple02 order by sabun";
		List<Map<String, Object>> list = new ArrayList<>();
		try{
			conn = MyOracle.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Map<String, Object> map = new HashMap<>();
				map.put("sabun", rs.getInt("sabun"));
				map.put("name", rs.getString("name"));
				map.put("nalja", rs.getString("nalja"));
				map.put("pay", rs.getInt("pay"));
				list.add(map);
			}
		}finally{
			closeAll();
		}
		return list;
	}
	
	public Map<String, Object> selectOne(int sabun) throws SQLException{
		String sql = "select * from simple02 where sabun=?";
		Map<String, Object> bean = new HashMap<>();
		try{
			conn = MyOracle.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sabun);
			rs = pstmt.executeQuery();
			if(rs.next()){
				bean.put("sabun", rs.getInt("sabun"));
				bean.put("name", rs.getString("name"));
				bean.put("nalja", rs.getString("nalja"));
				bean.put("pay", rs.getString("pay"));
			}
		}finally{
			closeAll();
		}
		return bean;
	}
	
	private void closeAll() throws SQLException {
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
	}
}
