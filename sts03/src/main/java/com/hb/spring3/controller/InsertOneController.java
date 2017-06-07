package com.hb.spring3.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.hb.spring3.model.SimpleDao;
import com.hb.spring3.model.SimpleVo;

public class InsertOneController extends AbstractCommandController {
	
	private SimpleDao dao;

	public void setDao(SimpleDao dao) {
		this.dao = dao;
	}
	
	public InsertOneController(Class commandName) {
		setCommandClass(commandName);
	}
	
	@Override
	protected ModelAndView handle(HttpServletRequest arg0
			, HttpServletResponse arg1
			, Object obj, BindException arg3)
			throws Exception {
		ModelAndView mav = new ModelAndView("redirect:list.do");
		dao.insertOne((SimpleVo)obj);
		return mav;
	}

}