package com.hb.spring3.model;

import static org.junit.Assert.assertEquals;
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
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("/context-config.xml");
		dao = (SimpleDaoImpl) ac.getBean("simpleDao"); //context-config.xml에서의 bean 태그 simpleDao 호출
		// 자바에서의 static 처럼 스프링 프레임워크가 시작 전에 
		// heap 영역에 객체를 xml에 설정되어 있는 것을 바탕으로 객체들을 미리 만들어놓는다. 
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
	public void testSelectOne() throws SQLException {
		// 342 efwe 2017-06-05 6464;
		SimpleVo me = new SimpleVo(
				1111,"efwe",null,6464);
		SimpleVo bean = dao.selectOne(me.getSabun());
//		if(me.equals(bean)){
//			assertTrue(true);
//		}
		assertEquals(me, bean);
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
