package com.hb.spring2.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hb.spring2.util.MyOracle;

public class SimpleDao implements DaoImpl{
	private DaoImpl dao;
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	public SimpleDao() {
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public List<SimpleVo> selectAll() throws SQLException {
		String sql = "SELECT * FROM simple03 ORDER BY sabun";
		List<SimpleVo> list = new ArrayList<>();
		try{
			conn = MyOracle.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
				while (rs.next()) {
					list.add(new SimpleVo(rs.getInt("sabun")
							, rs.getString("name")
							, rs.getDate("nalja")
							, rs.getInt("pay")
							));
				}
		}finally{
			closeAll();
		}
		return list;
	}
	private void closeAll() throws SQLException {
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
	}
	public void insertOne(SimpleVo simpleVo) throws SQLException {
		String sql = "insert into simple03 values (?,?,sysdate,?)";
		try{
			conn = MyOracle.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, simpleVo.getSabun());
			pstmt.setString(2, simpleVo.getName());
			pstmt.setInt(3, simpleVo.getPay());
			pstmt.executeUpdate();
		}finally{
			closeAll();
		}
	}
}
