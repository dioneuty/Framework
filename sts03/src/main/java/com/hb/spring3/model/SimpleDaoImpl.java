package com.hb.spring3.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

public class SimpleDaoImpl implements SimpleDao {
	private Logger log = Logger.getLogger(this.getClass());
	private DataSource ds;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public SimpleDaoImpl(DataSource ds) {
		this.ds=ds;
	}
	
	private void closeAll() throws SQLException {
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
		if(conn!=null)conn.close();
	}
	
	@Override
	public List<SimpleVo> selectAll() throws SQLException {
		String sql="SELECT * FROM SIMPLE03 ORDER BY SABUN";
		List<SimpleVo> list = new ArrayList<>();
		try{
			conn=ds.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			int cnt=0;
			while(rs.next()){
				list.add(new SimpleVo(
						rs.getInt("sabun")
						,rs.getString("name")
						,rs.getDate("nalja")
						,rs.getInt("pay")
						));
				log.debug(list.get(cnt++));
			}
		}finally {
			closeAll();
		}
		return list;
	}

	@Override
	public SimpleVo selectOne(int sabun) throws SQLException {
		String sql="SELECT * FROM SIMPLE03 WHERE SABUN=?";
		try{
			conn=ds.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, sabun);
			rs=pstmt.executeQuery();
			if(rs.next())
				return new SimpleVo(
						rs.getInt("sabun")
						,rs.getString("name")
						,rs.getDate("nalja")
						,rs.getInt("pay")
						);
		}finally {
			closeAll();
		}
		return null;
	}

	@Override
	public int insertOne(SimpleVo bean) throws SQLException {
		String sql="INSERT INTO SIMPLE03 VALUES (?,?,SYSDATE,?)";
		try{
			conn=ds.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, bean.getSabun());
			pstmt.setString(2, bean.getName());
			pstmt.setInt(3, bean.getPay());
			return pstmt.executeUpdate();
		}finally {
			closeAll();
		}
	}

	@Override
	public int updateOne(SimpleVo bean) throws SQLException {
		String sql = "update simple03 set name=?,pay=? where sabun=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getName());
			pstmt.setInt(2, bean.getPay());
			pstmt.setInt(3, bean.getSabun());
			return pstmt.executeUpdate();
		} finally {
			closeAll();
		}
	}
	@Override
	public int deleteOne(int sabun) throws SQLException {
		String sql = "delete from simple03 where sabun=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sabun);
			return pstmt.executeUpdate();
		} finally {
			closeAll();
		}
	}


	@Override
	public int payPlus(int sabun) throws SQLException {
		try{}finally {
			closeAll();
		}
		return 0;
	}

}