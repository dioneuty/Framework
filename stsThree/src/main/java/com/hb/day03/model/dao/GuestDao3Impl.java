package com.hb.day03.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.hb.day03.model.dto.GuestVo;

public class GuestDao3Impl implements GuestDao{
//	@Autowired
	private JdbcTemplate jdbcOperations;
	
	public void setJdbcOperations(JdbcTemplate jdbcOperations) {
		this.jdbcOperations = jdbcOperations;
	}
	
	@Override
	public List<GuestVo> selectAll() throws SQLException {
//		return queryForList("select * from guest_day03", GuestVo.class);
		return jdbcOperations.query("select * from guest_day03", new RowMapper<GuestVo>(){
			@Override
			public GuestVo mapRow(ResultSet rs, int idx) throws SQLException {
				System.out.println("impl2 ½ÇÇà");
				GuestVo bean = new GuestVo();
				bean.setSabun(rs.getInt("sabun"));
				bean.setName(rs.getString("name"));
				bean.setNalja(rs.getString("nalja"));
				bean.setPay(rs.getInt("pay"));
				return bean;
			}
		});	
	}

	@Override
	public GuestVo selectOne(int sabun) throws SQLException {
		return (GuestVo) (jdbcOperations.queryForObject("select * from guest_day03 where sabun=?", new Object[]{sabun}, new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int idx) throws SQLException {
				GuestVo bean = new GuestVo(rs.getInt("sabun"), rs.getString("name"), rs.getString("nalja"), rs.getInt("pay"));
				return bean;
			}
		}));
	}

	@Override
	public void insertOne(GuestVo bean) throws SQLException {
		Object[] obj = {bean.getSabun(), bean.getName(), bean.getPay()};
		jdbcOperations.update("insert into guest_day03 values(?,?,to_char(sysdate,'yyyy/mm/dd'),?)", obj);
	}

	@Override
	public int updateOne(GuestVo bean) throws SQLException {
		return jdbcOperations.update("update guest day03 set name=?, pay=? where sabun=?",new Object[]{bean.getName(),bean.getPay(),bean.getSabun()});
	}

	@Override
	public int deleteOne(int sabun) throws SQLException {
		return jdbcOperations.update("delete from guest_day03 where sabun=?", sabun);
	}

	@Override
	public int payPlus(int sabun) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
