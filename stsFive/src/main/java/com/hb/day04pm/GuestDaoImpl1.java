package com.hb.day04pm;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.hb.day04pm.model.dto.GuestVo;

public class GuestDaoImpl1 implements GuestDao {
	
	private SqlSessionFactory sqlSessionFactory;

	public GuestDaoImpl1() throws IOException {
		String resource = "./mybatis-config.xml";
		
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
		} catch (Exception e) {
			System.out.println("config파일 리딩 오류");
		}
	}
	
	@Override
	public List<GuestVo> selectAll() throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		List<GuestVo> list = session.selectList("guest.selectAll"); //네임스페이스.name
		System.out.println(list);
		return list;
	}

	@Override
	public GuestVo selectOne(int sabun) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertOne(GuestVo bean) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public int updateOne(GuestVo bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOne(int sabun) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
