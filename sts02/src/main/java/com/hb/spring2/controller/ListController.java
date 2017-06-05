package com.hb.spring2.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.hb.spring2.model.DaoImpl;
import com.hb.spring2.model.SimpleDao;
import com.hb.spring2.model.SimpleVo;

public class ListController implements Controller {
	private DaoImpl dao;
	
	public void setDao(DaoImpl dao) {
		this.dao = dao;
	}
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		ModelAndView mav = new ModelAndView();
		System.out.println("list dao"+dao);
		List<SimpleVo> alist = new ArrayList();
		
		mav.addObject("alist", dao.selectAll());
		mav.setViewName("list");
		return mav;
	}

}
