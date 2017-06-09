package com.hb.day02.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

public class GuestUserDaoImpl implements GuestUserDao<GuestUserVo> {
	@Autowired
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DataSource dataSource;
	
	/*public GuestUserDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}*/
	
	@Override
	public List<GuestUserVo> selectAll() throws SQLException {
		String sql = "select * from guest_user order by num";
		List<GuestUserVo> list = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			//자원 절약
			list = new ArrayList<GuestUserVo>(); 
			while (rs.next()) {
				list.add(new GuestUserVo(
					rs.getInt("num")
					, rs.getInt("sabun")
					, rs.getString("name")
					, rs.getDate("nalja")
					));
			}
		} finally {
			closeAll();
		}
		return list;
	}

	@Override
	public GuestUserVo selectOne(int idx) throws SQLException {
		return null;
	}

	@Override
	public void insertOne(GuestUserVo bean) throws SQLException {
	}

	@Override
	public int updateOne(GuestUserVo bean) throws SQLException {
		return 0;
	}

	@Override
	public int deleteOne(int idx) throws SQLException {
		return 0;
	}
	
	private void closeAll() throws SQLException {
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
	}
}
