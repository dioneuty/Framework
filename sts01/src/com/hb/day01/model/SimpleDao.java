package com.hb.day01.model;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class SimpleDao {
	private Connection conn;

	public List<SimpleVo> selectAll() {
		String sql = "select * from guest03 order by sabun";
		List<SimpleVo> list = new ArrayList<>();
		
		list.add(new SimpleVo(1111,"test1",
				new Date(System.currentTimeMillis()),1000));
		list.add(new SimpleVo(2222,"test2",
				new Date(System.currentTimeMillis()),1000));
		list.add(new SimpleVo(3333,"test3",
				new Date(System.currentTimeMillis()),1000));
		
		return list;
	}
}
