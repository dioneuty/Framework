package com.hb.day02.user.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GuestUserDaoImplTest {
	private static GuestUserDaoImpl dao;
	
	@BeforeClass
	public static void beforeTest() {
		String path = "/config-context.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(path);
		dao = (GuestUserDaoImpl) ac.getBean("guestUserDao");
	}
	
	@Test
	public void testSelectAll() throws SQLException {
		List<GuestUserVo> list = dao.selectAll();
		assertNotNull("list==null", list);
		assertSame(0, list.size());
	}

//	@Test
//	public void testSelectOne() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testInsertOne() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testUpdateOne() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDeleteOne() {
//		fail("Not yet implemented");
//	}

}
