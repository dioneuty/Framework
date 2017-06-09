package com.hb.day02.user.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GuestUserDaoImplTest {
	private GuestUserDaoImpl dao;
	
	@BeforeClass
	public void beforeTest() {
		String path = "/config-context.xml";
	}
	
	@Test
	public void testSelectAll() throws SQLException {
		List<GuestUserVo> list = dao.selectAll();
		assertNotNull("list==null", list);
		assertSame(0, list.size());
	}

	@Test
	public void testSelectOne() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertOne() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateOne() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteOne() {
		fail("Not yet implemented");
	}

}
