package com.hb.day05am.service;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.hb.day05am.model.GuestDao;
import com.hb.day05am.model.GuestVo;

public class ServiceImpl implements ServiceCommand {

	@Override
	public void listService(SqlSession sqlSession, Model model) throws SQLException {
		GuestDao dao = sqlSession.getMapper(GuestDao.class);
		try {
			model.addAttribute("alist", dao.selectAll());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void detailService(SqlSession sqlSession, Model model, int idx) throws SQLException {
		GuestDao dao = sqlSession.getMapper(GuestDao.class);
		try {
			model.addAttribute("bean", dao.selectOne(idx));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addService(SqlSession sqlSession, GuestVo bean) throws SQLException {
		GuestDao dao = sqlSession.getMapper(GuestDao.class);
		try {
			dao.insertOne(bean);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void editService(SqlSession sqlSession, GuestVo bean) throws SQLException {
		GuestDao dao = sqlSession.getMapper(GuestDao.class);
		try {
			dao.updateOne(bean);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteService(SqlSession sqlSession, int idx) throws SQLException {
		GuestDao dao = sqlSession.getMapper(GuestDao.class);
		try {
			dao.deleteOne(idx);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
