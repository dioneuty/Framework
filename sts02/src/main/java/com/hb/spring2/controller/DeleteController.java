package com.hb.spring2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.hb.spring2.model.DaoImpl;
import com.hb.spring2.model.SimpleVo;

public class DeleteController extends AbstractCommandController {
	private DaoImpl dao;
	
	public void setDao(DaoImpl dao) {
		this.dao = dao;
	}
	public DeleteController(Class commandClass) {
		super(commandClass);
	}
	
	@Override
	protected ModelAndView handle(HttpServletRequest req, HttpServletResponse resp, Object command, BindException error)
			throws Exception {
		ModelAndView mav = new ModelAndView();
		SimpleVo bean = (SimpleVo) command;
		if(dao.deleteOne(bean) > 0){
			mav.setViewName("redirect:list.do");
		}else{
			mav.setViewName("redirect:detail.do?idx="+bean.getSabun());
		}
		return mav;
	}

}
