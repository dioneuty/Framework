package com.hb.spring3.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.hb.spring3.model.SimpleDao;

public class SelectOneController implements Controller {
	private SimpleDao dao;
	private String viewName;
	
	//오토와이어 어노테이션 보류
	public void setDao(SimpleDao dao) {
		this.dao = dao;
	}
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse arg1) throws Exception {
		ModelAndView mav=new ModelAndView(viewName);
		System.out.println(dao);
		mav.addObject("bean"
		, dao.selectOne(Integer.parseInt(req.getParameter("idx"))));
		return mav;
	}

}