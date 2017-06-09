package com.hb.day02.user.model;

import java.sql.SQLException;
import java.util.List;

public interface GuestUserDao<T> {
	List<T> selectAll() throws SQLException;
	T selectOne(int idx) throws SQLException;
	void insertOne(T bean) throws SQLException;
	int updateOne(T bean) throws SQLException;
	int deleteOne(int idx) throws SQLException;
}
