package com.hb.spring2.model;

import java.sql.SQLException;
import java.util.List;

public interface DaoImpl {
	List<SimpleVo> selectAll();
	void insertOne(SimpleVo simpleVo);
}
