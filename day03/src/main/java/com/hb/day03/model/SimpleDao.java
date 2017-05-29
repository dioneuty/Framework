package com.hb.day03.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hb.day03.support.UpdateJDBC;
import com.hb.day03.support.UpdateJDBC2;

public class SimpleDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public SimpleDao() {
		String url="jdbc:h2:tcp://localhost/~/test";
		String user="sa";
		String password="";
		try {
			Class.forName("org.h2.Driver");
			conn=DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<SimpleVo> selectAll() throws SQLException {
		String sql="SELECT * FROM SIMPLE02";
		UpdateJDBC2 jdbc = new UpdateJDBC2() {
			
			@Override
			public Object mapper(ResultSet rs) throws SQLException {
				List<SimpleVo> list = new ArrayList<>();
				while(rs.next()){
					SimpleVo bean = new SimpleVo();
					bean.setSabun(rs.getInt("sabun"));
					bean.setName(rs.getString("name"));
					bean.setNalja(rs.getString("nalja"));
					bean.setPay(rs.getInt("pay"));
					list.add(bean);
				}
				return list;
			}
		};
		return (List) jdbc.executeQuery(sql);
	}
	
	public SimpleVo selectOne(int sabun) throws SQLException {
		String sql="SELECT * FROM SIMPLE02 WHERE SABUN=?";
		Object[] objs = new Object[]{sabun};
		UpdateJDBC2 jdbc = new UpdateJDBC2() {
			
			@Override
			public Object mapper(ResultSet rs) throws SQLException {
				SimpleVo bean = new SimpleVo();
				if(rs.next()){
				bean.setSabun(rs.getInt("sabun"));
				bean.setName(rs.getString("name"));
				bean.setNalja(rs.getString("nalja"));
				bean.setPay(rs.getInt("pay"));
				}
				return bean;
			}
		};
		return (SimpleVo) jdbc.executeQuery(sql,objs);
	}
	

	private void close() throws SQLException {
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
		if(conn!=null)conn.close();
	}

	public int insertOne(String name, String nalja, int pay) throws SQLException {
		String sql="insert into simple02 (name,nalja,pay) ";
		sql+=" values (?,?,?)";
		Object[] objs = new Object[]{name,nalja,pay};
		UpdateJDBC jdbc = new UpdateJDBC();
		return jdbc.executeUpdate(sql, objs);
	}

	public int updateOne(int sabun, String name, String nalja, int pay) throws SQLException {
		String sql = "update simple02 set name=?,nalja=?,pay=? where sabun=?";
		Object[] objs = new Object[]{name,nalja,pay,sabun};
		UpdateJDBC jdbc = new UpdateJDBC();
		return jdbc.executeUpdate(sql, objs);
		
	}
	public List temp(ResultSet rs) throws SQLException{
		List<SimpleVo> list = new ArrayList<>();
		while(rs.next()){
			SimpleVo bean = new SimpleVo();
			bean.setSabun(rs.getInt("sabun"));
			bean.setName(rs.getString("name"));
			bean.setNalja(rs.getString("nalja"));
			bean.setPay(rs.getInt("pay"));
			list.add(bean);
		}
		return list;
	}
}