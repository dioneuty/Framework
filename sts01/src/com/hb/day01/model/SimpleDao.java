package com.hb.day01.model;

import java.sql.Connection;
import java.sql.Date;
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
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<SimpleVo> selectAll() throws SQLException {
		String sql = "select * from simple03 order by sabun";
		List<SimpleVo> list = new ArrayList<>();
		try{
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				list.add(new SimpleVo(rs.getInt("sabun")
						, rs.getString("name")
						, rs.getDate("nalja")
						, rs.getInt("pay")));
			}
		}finally{
			closeAll();
		}
		
		return list;
	}

	private void closeAll() throws SQLException {
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
		if(conn!=null)conn.close();
	}
	public int insertOne(SimpleVo bean) throws SQLException {
		String sql = "insert into simple03 values (?,?,sysdate,?)";
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bean.getSabun());
			pstmt.setString(2, bean.getName());
			pstmt.setInt(3, bean.getPay());
			return pstmt.executeUpdate();
		}finally{
			closeAll();
		}
	}
	public SimpleVo selectOne(int sabun) throws SQLException {
		String sql = "select * from simple03 where sabun=?";
		SimpleVo bean = null;
		try{
			pstmt =conn.prepareStatement(sql);
			pstmt.setInt(1, sabun);
			rs = pstmt.executeQuery();
			if(rs.next()){
				bean = new SimpleVo(rs.getInt("sabun"), 
						rs.getString("name"), 
						rs.getDate("nalja"), 
						rs.getInt("pay"));
			}
		}finally{
			closeAll();
		}
		return bean;
	}
	public int updateOne(SimpleVo bean) throws SQLException {
		String sql = "UPDATE SIMPLE03 SET NAME=?, PAY=? WHERE SABUN=?";
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getName());
			pstmt.setInt(2, bean.getPay());
			pstmt.setInt(3, bean.getSabun());
			return pstmt.executeUpdate();
		}finally{
			closeAll();
		}
	}
	public int deleteOne(int parseInt) throws SQLException {
		String sql = "DELETE FROM SIMPLE03 WHERE SABUN=?";
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, parseInt);
			return pstmt.executeUpdate();
		}finally{
			closeAll();
		}
	}
}
