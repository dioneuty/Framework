package com.hb.day03.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hb.day03.support.RowMapper;
import com.hb.day03.support.JDBCTemplate;

public class SimpleDao {
	private JDBCTemplate jdbc;
	
	public SimpleDao() {
		Connection conn = null;
		String url="jdbc:h2:tcp://localhost/~/test";
		String user="sa";
		String password="";
		try {
			Class.forName("org.h2.Driver");
			conn=DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jdbc = new JDBCTemplate(conn);
	}

	public List<SimpleVo> selectAll() throws SQLException {
		String sql="SELECT * FROM SIMPLE02";
		return jdbc.queryList(sql,new RowMapper(){
			@Override
			public Object mapRow(ResultSet rs) throws SQLException {
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
		});
	}
	
	public SimpleVo selectOne(int sabun) throws SQLException {
		String sql="SELECT * FROM SIMPLE02 WHERE SABUN=?";
		Object[] objs = new Object[]{sabun};
		return (SimpleVo) jdbc.executeQuery(sql,objs,new RowMapper(){
			@Override
			public Object mapRow(ResultSet rs) throws SQLException {
				SimpleVo bean = new SimpleVo();
				if(rs.next()){
					bean.setSabun(rs.getInt("sabun"));
					bean.setName(rs.getString("name"));
					bean.setNalja(rs.getString("nalja"));
					bean.setPay(rs.getInt("pay"));
				}
				return bean;
			}
		});
	}

	public int insertOne(String name, String nalja, int pay) throws SQLException {
		String sql="insert into simple02 (name,nalja,pay) values (?,?,?)";
		Object[] objs = new Object[]{name,nalja,pay};
		return jdbc.executeUpdate(sql, objs);
	}
	
	public int updateOne(int sabun, String name, String nalja, int pay) throws SQLException {
		String sql = "update simple02 set name=?,nalja=?,pay=? where sabun=?";
		Object[] objs = new Object[]{name,nalja,pay,sabun};
		return jdbc.executeUpdate(sql, objs);
	}
	
	public int deleteOne(int sabun) throws SQLException{
		String sql="detete from simple02 where sabun=?";
		return jdbc.executeUpdate(sql, new Object[]{sabun});
	}
}