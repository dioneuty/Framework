package com.hb.day03.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hb.day03.model.dto.GuestVo;

public interface GuestDao {
	List<GuestVo> selectAll() throws SQLException;
	GuestVo selectOne(int sabun) throws SQLException;
	void insertOne(GuestVo bean) throws SQLException;
	int updateOne(GuestVo bean) throws SQLException;
	int deleteOne(int sabun) throws SQLException;
	int payPlus(int sabun) throws SQLException;
}