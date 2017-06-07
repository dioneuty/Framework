package com.hb.spring3.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class SimpleDaoImpl implements SimpleDao {
	private DataSource ds;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public void setDs(DataSource ds) {
		this.ds = ds;
	}
	
	public SimpleDaoImpl(DataSource ds) {
		this.ds = ds;
	}
	
	private void closeAll() throws SQLException {
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(conn!=null) conn.close();
	}
	@Override
	public List<SimpleVo> selectAll() throws SQLException {
		String sql = "select * from simple03 order by sabun";
		List<SimpleVo> list = new ArrayList<>();
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				list.add(new SimpleVo(
						rs.getInt("sabun")
						,rs.getString("name")
						, rs.getDate("nalja")
						,rs.getInt("pay")
						));
			}
		} finally {
			closeAll();
		}
		return list;
	}

	@Override
	public SimpleVo selectOne(int sabun) throws SQLException {
		String sql = "select * from simple03 where sabun=?";
		try{
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sabun);
			rs = pstmt.executeQuery();
			if(rs.next()){
				return new SimpleVo(
						rs.getInt("sabun")
						, rs.getString("name")
						, rs.getDate("nalja")
						, rs.getInt("pay")
						);
			}
		}finally {
			closeAll();
		}
		return null;
	}

	@Override
	public int insertOne(SimpleVo bean) throws SQLException {
		try{}finally {
			closeAll();
		}
		return 0;
	}

	@Override
	public int updateOne(SimpleVo bean) throws SQLException {
		try{}finally {
			closeAll();
		}
		return 0;
	}

	@Override
	public int deleteOne(int sabun) throws SQLException {
		try{}finally {
			closeAll();
		}
		return 0;
	}

	@Override
	public int payPlus(int sabun) throws SQLException {
		try{}finally {
			closeAll();
		}
		return 0;
	}

}
