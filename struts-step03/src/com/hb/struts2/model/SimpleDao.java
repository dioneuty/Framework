package com.hb.struts2.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class SimpleDao {

	public List<SimpleVo> seletAll() {
		List<SimpleVo> list = new ArrayList();
		list.add(new SimpleVo(1111,"test1",new Date(System.currentTimeMillis()),4321));
		list.add(new SimpleVo(2222,"test2",new Date(System.currentTimeMillis()),4321));
		list.add(new SimpleVo(3333,"test3",new Date(System.currentTimeMillis()),4321));
		return list;
	}

}
