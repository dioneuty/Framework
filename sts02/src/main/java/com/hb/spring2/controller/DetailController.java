package com.hb.spring2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.hb.spring2.model.DaoImpl;

public class DetailController extends AbstractController {
	private DaoImpl dao;
	private String viewName;
	
	public void setDao(DaoImpl dao) {
		this.dao = dao;
	}
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("bean", dao.selectOne(Integer.parseInt(req.getParameter("idx"))));
		mav.setViewName(viewName);
		return mav;
	}

}
