package com.hb.spring3.model;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.List;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SimpleDaoImplTest {

	private static SimpleDaoImpl dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
//		BasicDataSource ds = null;
//		ds = new org.apache.tomcat.dbcp.dbcp.BasicDataSource();
//		ds.setDriverClassName("oracle.jdbc.OracleDriver");
//		ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
//		ds.setUsername("scott");
//		ds.setPassword("tiger");
//		//((SimpleDaoImpl)dao).setDs(ds);
//		dao = new SimpleDaoImpl(ds); //객체 하나만 생성(Singleton)
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSelectAll() throws SQLException {
		List<SimpleVo> list = dao.selectAll();
		if(list != null){
			assertTrue(true);
			assertTrue(list.size() > 0);
			return;
		}
		fail("Not yet implemented");
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

	@Test
	public void testPayPlus() {
		fail("Not yet implemented");
	}

}
