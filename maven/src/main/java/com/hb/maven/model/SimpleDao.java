package com.hb.maven.model;

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
	
	public SimpleDao(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott","tiger");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List selectAll() throws SQLException {
		String sql = "select * from guest01";
		List<SimpleVo> list = new ArrayList<SimpleVo>();
		try{
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				SimpleVo vo = new SimpleVo();
				vo.setSabun(rs.getInt("sabun"));
				vo.setName(rs.getString("name"));
				vo.setNalja(rs.getString("nalja"));
				vo.setPay(rs.getInt("pay"));
				list.add(vo);
			}
		} finally{
			close();
		}
		return list;
	}

	private void close() throws SQLException {
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
	}

	public int insertOne(SimpleVo vo) throws SQLException {
		String sql = "insert into guest01(name, nalja, pay) values(?, ?, ?)";
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getNalja());
			pstmt.setInt(3, vo.getPay());
			return pstmt.executeUpdate();
		}finally{
			close();
		}
	}
	
	
	
}
