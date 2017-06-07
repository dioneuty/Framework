package com.hb.spring3.model;

import java.sql.SQLException;
import java.util.List;

public interface SimpleDao {
	List<SimpleVo> selectAll() throws SQLException;
	SimpleVo selectOne(int sabun) throws SQLException;
	int insertOne(SimpleVo bean) throws SQLException;
	int updateOne(SimpleVo bean) throws SQLException;
	int deleteOne(int sabun) throws SQLException;
	int payPlus(int sabun) throws SQLException;
}
