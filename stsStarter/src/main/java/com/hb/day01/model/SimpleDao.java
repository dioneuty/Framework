package com.hb.day01.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hb.day01.util.MyOracle;

public class SimpleDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public List<SimpleVo> selectAll() throws SQLException{
		String sql = "SELECT * FROM simple03 ORDER BY sabun";
		List<SimpleVo> list = null;
		try {
			conn = MyOracle.getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			//자원 절약
			list = new ArrayList<SimpleVo>(); 
			while (rs.next()) {
				list.add(new SimpleVo(rs.getInt("sabun")
						, rs.getString("name")
						, rs.getDate("nalja")
						, rs.getInt("pay")
						));
			}
		} finally {
			closeAll();
		}
		return list;
	}

	private void closeAll() throws SQLException {
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
	}

	public void insertOne(int sabun, String name, int pay) throws SQLException {
		String sql = "insert into simple03 values (?,?,sysdate,?)";
		try {
			conn = MyOracle.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sabun);
			pstmt.setString(2, name);
			pstmt.setInt(3, pay);
			pstmt.executeUpdate();
		} finally {
			closeAll();
		}
	}

	public SimpleVo detailOne(int num) throws SQLException {
		String sql = "select * from simple03 where sabun=?";
		SimpleVo bean = null;
		try {
			conn = MyOracle.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()){
				bean = new SimpleVo(rs.getInt("sabun")
						, rs.getString("name")
						, rs.getDate("nalja")
						, rs.getInt("pay")
						);
			}
		} finally {
			closeAll();
		}
		return bean;
	}

	public int updateOne(int sabun, String name, int pay) throws SQLException {
		String sql = "update simple03 set name=?, nalja=sysdate, pay=? where sabun=?";
		try {
			conn = MyOracle.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, pay);
			pstmt.setInt(3, sabun);
			return pstmt.executeUpdate();
		} finally {
			closeAll();
		}
	}

	public int deleteOne(int sabun) throws SQLException {
		String sql = "delete from simple03 where sabun=?";
		try {
			conn = MyOracle.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sabun);
			return pstmt.executeUpdate();
		} finally {
			closeAll();
		}
	}
}
