package com.hb.day03.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.hb.day03.model.dto.GuestVo;

public class GuestDaoImpl implements GuestDao {
	@Autowired
	private DataSource dataSource;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	/*public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}*/
	
	@Override
	public List<GuestVo> selectAll() throws SQLException {
		String sql = "select * from guest_day03 order by sabun";
		List<GuestVo> list = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<GuestVo>();
			while(rs.next()){
				list.add(new GuestVo(rs.getInt("sabun"), rs.getString("name"), rs.getString("nalja"), rs.getInt("pay")));
			}
		} finally {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}
		return list;
	}

	@Override
	public GuestVo selectOne(int sabun) throws SQLException {
		String sql = "select * from guest_day03 where sabun=?";
		GuestVo bean = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sabun);
			rs = pstmt.executeQuery();
			if(rs.next()){
				return new GuestVo(rs.getInt("sabun"), rs.getString("name"), rs.getString("nalja"), rs.getInt("pay"));
			}
		} finally {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}
		return null;
	}

	@Override
	public void insertOne(GuestVo bean) throws SQLException {
		String sql = "insert into guest_day03 values(?,?,to_char(sysdate,'yyyy/mm/dd'),?)";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bean.getSabun());
			pstmt.setString(2, bean.getName());
			pstmt.setInt(3, bean.getPay());
			pstmt.executeUpdate();
		} finally {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}
	}

	@Override
	public int updateOne(GuestVo bean) throws SQLException {
		String sql = "update guest_day03 set name=?, pay=? where sabun=?";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getName());
			pstmt.setInt(2, bean.getPay());
			pstmt.setInt(3, bean.getSabun());
			return pstmt.executeUpdate();
		} finally {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}
	}

	@Override
	public int deleteOne(int sabun) throws SQLException {
		String sql = "delete from guest_day03 where sabun=?";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sabun);
			return pstmt.executeUpdate();
		} finally {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}
	}

	@Override
	public int payPlus(int sabun) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
