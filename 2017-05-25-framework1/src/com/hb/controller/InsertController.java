package com.hb.controller;

import javax.servlet.http.HttpServletRequest;

import com.hb.engine.FrontImp;
import com.hb.model.SampleDao;

public class InsertController implements FrontImp{
	public String execute(HttpServletRequest req){
		try{
			SampleDao dao = new SampleDao();
			int sabun=Integer.parseInt(req.getParameter("sabun"));
			String name = req.getParameter("name");
			int pay=Integer.parseInt(req.getParameter("pay"));
			dao.insertOne(sabun, name, pay);
			dao.closeAll();
		}catch (Exception e){
			e.printStackTrace();
		}
		return "list.do";
	}
}
