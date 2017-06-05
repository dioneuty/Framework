package com.hb.spring2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class IndexController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ModelAndView mav = new ModelAndView();
		if(req.getRequestURI().equals("/sts02/index.do")){
			mav.setViewName("main");			
		}else if(req.getRequestURI().equals("/sts02/add.do")) {
			mav.setViewName("add");			
		}
		return mav;
	}

}
