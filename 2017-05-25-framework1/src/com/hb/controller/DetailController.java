package com.hb.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.hb.model.SampleDao;

public class DetailController {
	public String execute(HttpServletRequest req){
		try{
			SampleDao dao = new SampleDao();
			Map<String,Object>map = dao.selectOne(Integer.parseInt(req.getParameter("idx")));
			req.setAttribute("bean", map);			
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return "/detail.jsp";
	}
}
