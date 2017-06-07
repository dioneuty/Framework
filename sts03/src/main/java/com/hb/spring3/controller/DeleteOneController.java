package com.hb.spring3.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.hb.spring3.model.SimpleDao;
import com.hb.spring3.model.SimpleVo;

public class DeleteOneController extends AbstractCommandController {
	
	private SimpleDao dao;

	public void setDao(SimpleDao dao) {
		this.dao = dao;
	}
	
	public DeleteOneController(Class commandName) {
		setCommandClass(commandName);
	}
	
	@Override
	protected ModelAndView handle(HttpServletRequest req
			, HttpServletResponse resp
			, Object obj, BindException arg3)
			throws Exception {
		ModelAndView mav = new ModelAndView();
		int sabun = Integer.parseInt(req.getParameter("idx"));
		//SimpleVo bean = (SimpleVo) obj;
		if(dao.deleteOne(sabun)>0){
			mav.setViewName("redirect:list.do");			
		}else{
			mav.setViewName("redirect:detail.do?idx="+sabun);
		}
		return mav;
	}

}