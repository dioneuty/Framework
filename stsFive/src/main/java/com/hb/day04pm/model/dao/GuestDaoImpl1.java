package com.hb.day04pm.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.hb.day04pm.model.dto.GuestVo;

public class GuestDaoImpl1 implements GuestDao {
	
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	/*public GuestDaoImpl1() throws IOException {
		String resource = "./mybatis-config.xml";
		
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
		} catch (Exception e) {
			System.out.println("config���� ���� ����");
		}
	}*/
	
	@Override
	public List<GuestVo> selectAll() throws SQLException {
//		session = sqlSessionFactory.openSession();
		List<GuestVo> list = sqlSession.selectList("guest.selectAll"); //���ӽ����̽�.name
		System.out.println(list);
		return list;
	}

	@Override
	public GuestVo selectOne(int sabun) throws SQLException {
		return sqlSession.selectOne("guest.selectOne", sabun);
	}

	@Override
	public void insertOne(GuestVo bean) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public int updateOne(GuestVo bean) throws SQLException {
		return sqlSession.update("guest.updateOne", bean);
	}

	@Override
	public int deleteOne(int sabun) throws SQLException {
		return sqlSession.delete("guest.deleteOne", sabun);
	}

}
