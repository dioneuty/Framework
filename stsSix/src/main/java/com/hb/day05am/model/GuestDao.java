package com.hb.day05am.model;

import java.sql.SQLException;
import java.util.List;

public interface GuestDao {
	List<GuestVo> selectAll() throws SQLException;
	GuestVo selectOne(int sabun) throws SQLException;
	void insertOne(GuestVo bean) throws SQLException;
	int updateOne(GuestVo bean) throws SQLException;
	int deleteOne(int sabun) throws SQLException;
}
