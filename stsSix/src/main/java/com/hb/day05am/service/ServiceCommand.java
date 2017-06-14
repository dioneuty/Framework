package com.hb.day05am.service;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.hb.day05am.model.GuestVo;

public interface ServiceCommand {
	void listService(SqlSession sqlSession, Model model) throws SQLException;
	void detailService(SqlSession sqlSession, Model model, int idx) throws SQLException;
	void addService(SqlSession sqlSession, GuestVo bean) throws SQLException;
	void editService(SqlSession sqlSession, GuestVo bean) throws SQLException;
	void deleteService(SqlSession sqlSession, int idx) throws SQLException;
}
