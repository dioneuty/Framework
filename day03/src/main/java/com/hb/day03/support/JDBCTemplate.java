package com.hb.day03.support;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hb.day03.model.SimpleVo;

public class JDBCTemplate {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	public JDBCTemplate() {}
	public JDBCTemplate(Connection conn){
		this.conn = conn;
	}
	public int executeUpdate(String sql,Object[] objs) throws SQLException{
		PreparedStatement pstmt = conn.prepareStatement(sql);
		for(int i = 0; i < objs.length; i++){
			pstmt.setObject(i+1, objs[i]);
		}
		int result = pstmt.executeUpdate();
		close();
		return result;
	}
	private void close() throws SQLException {
		if(pstmt!=null)pstmt.close();
		if(conn!=null)conn.close();
	}
	public Object executeQuery(String sql, RowMapper mapper) throws SQLException{
		return executeQuery(sql, new Object[]{}, mapper);
	}
	public Object executeQuery(String sql, Object[] objs, RowMapper mapper) throws SQLException {
		pstmt = conn.prepareStatement(sql);
		for(int i = 0; i<objs.length; i++){
			pstmt.setObject(i+1, objs[i]);
		}
		rs = pstmt.executeQuery();
		Object obj = mapper.mapRow(rs);
		close();
		return obj;
	}
	public List queryList(String sql, RowMapper mapper) throws SQLException{
		return queryList(sql,new Object[]{},mapper);
	}
	public List queryList(String sql, Object[] objs, RowMapper mapper) throws SQLException {
		List list = mapper.list; 
		pstmt = conn.prepareStatement(sql);
		for(int i = 0; i<objs.length; i++){
			pstmt.setObject(i+1, objs[i]);
		}
		rs = pstmt.executeQuery();
		Object obj = mapper.mapRow(rs);
		close();
		return list;
	}
}
