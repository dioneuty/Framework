package com.hb.model;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DaoTest {
    static Logger log = Logger.getLogger(DaoTest.class);
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
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
		SampleDao dao = new SampleDao();
		List<Map<String, Object>> list = dao.selectAll();
		assertNotNull(list);
		assertTrue(list.size()>0);
		assertSame(3,list.size());
		for (Map<String, Object> map: list) {
			log.debug(map.get("sabun"));
		}
	}
}
