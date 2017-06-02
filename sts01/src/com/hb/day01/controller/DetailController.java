package com.hb.day01.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.hb.day01.model.SimpleDao;

public class DetailController implements Controller {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub
		
		ModelAndView mav = new ModelAndView();
		SimpleDao dao = new SimpleDao();
		int sabun = Integer.parseInt(req.getParameter("idx"));
		mav.addObject("bean",dao.selectOne(sabun));
		mav.setViewName("detail");
		//if(req.getRequestURI())
		log.debug(req.getRequestURI());
		//context path 제거
		String path = req.getRequestURI().replace(req.getContextPath(), "");
		if(path.equals("/detail.do")){
			mav.setViewName("detail");
		}else if(path.equals("/edit.do")){
			mav.setViewName("edit");
		}
		return mav;
	}

}
