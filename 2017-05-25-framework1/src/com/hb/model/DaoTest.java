package com.hb.model;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DaoTest {
    static Logger log = Logger.getLogger(DaoTest.class);
	static SampleDao dao;
	
	@BeforeClass
	public static void setUpBeforeclass() throws Exception{
		//dao = new SampleDao(false);
	}
	@AfterClass
	public static void tearDownAfterCalss() throws Exception{
		//dao.back();
	}
	@Before
	public void setUp() throws Exception {
		dao = new SampleDao(false);
	}

	@After
	public void tearDown() throws Exception {
		dao.back();
	}

	@Test
	public void test() {
		assertTrue(true);
	}
	@Test
	public void testSampleDao() throws ClassNotFoundException, SQLException{
		assertNotNull(new SampleDao());
	}
	@Test
	public void testSelectAll() throws ClassNotFoundException, SQLException{
		//dao = new SampleDao();
		List<Map<String, Object>> list = dao.selectAll();
		assertNotNull(list);
		assertTrue(list.size()>0);
		assertSame(4,list.size());
		for (Map<String, Object> map: list) {
			log.debug(map.get("sabun"));
		}
	}
	@Test
	public void testSelectOne() throws ClassNotFoundException, SQLException{
		int sabun = 1;
		SampleDao dao = new SampleDao();
		Map<String, Object> map = dao.selectOne(sabun);
		assertNotNull(map);
		assertSame(1, map.get("sabun"));
		assertEquals(1, map.get("sabun"));
		assertEquals(1111, map.get("pay"));
	/*	log.debug(map.get("sabun"));
		log.debug(map.get("name"));
		log.debug(map.get("nalja"));
		log.debug(map.get("pay"));*/
	}
	@Test
	public void testInsertOne() throws SQLException{
		int sabun = 5;
		int pay = 5555;
		String name = "test";
		int result = dao.insertOne(sabun, name, pay);
		assertEquals(1, result);
	}
}
