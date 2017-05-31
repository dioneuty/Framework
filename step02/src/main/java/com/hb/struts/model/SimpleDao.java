package com.hb.struts.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SimpleDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public SimpleDao() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	public List<SimpleVo> selectAll() throws SQLException{
		List<SimpleVo> list = new ArrayList<>();
		String sql = "select * from simple03 order by sabun";
		try{
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				list.add(new SimpleVo(rs.getInt("sabun"),
						rs.getString("name"), 
						rs.getDate("nalja"),
						rs.getInt("pay")
						));
			}
		}finally{
			closeAll();
		}
		
		return list;
	}
	private void closeAll() throws SQLException {
		if (rs != null) rs.close();
		if (pstmt != null) pstmt.close();
		if (conn != null) conn.close();
	}
	public int insertOne(int sabun, String name, int pay) throws SQLException {
		int result = 0;
		String sql = "insert into simple03 (sabun,name,nalja,pay) values(?,?,sysdate,?)";
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sabun);
			pstmt.setString(2, name);
			pstmt.setInt(3, pay);
			result = pstmt.executeUpdate();
		}finally{
			closeAll();
		}
		return result;
	}
}
