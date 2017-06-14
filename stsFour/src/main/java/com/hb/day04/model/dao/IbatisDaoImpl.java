package com.hb.day04.model.dao;

import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.hb.day04.model.dto.GuestVo;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class IbatisDaoImpl implements GuestDao {
	private SqlMapClient sqlMapClient;
	
	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}
	
	public IbatisDaoImpl() {
		String path="./sqlMapConfig.xml"; //惑措林家 
		try {
			Reader reader = Resources.getResourceAsReader(path);
			sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("dao 按眉 积己 肯丰" + sqlMapClient);
	}
	
	@Override
	public List<GuestVo> selectAll() throws SQLException {
		List<GuestVo> list = sqlMapClient.queryForList("selectAll");
		System.out.println(list);
		return list;
	}

	@Override
	public GuestVo selectOne(int sabun) throws SQLException {
		return (GuestVo) sqlMapClient.queryForObject("selectOne", sabun);
	}

	@Override
	public void insertOne(GuestVo bean) throws SQLException {
		sqlMapClient.insert("insertOne",bean);

	}

	@Override
	public int updateOne(GuestVo bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOne(int sabun) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
