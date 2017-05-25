package com.hb.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hb.model.SampleDao;

public class ListController {
	public String execute(HttpServletRequest req){

		SampleDao dao;
		try {
			dao = new SampleDao();
			//url+="/list";
			List list = dao.selectAll();
			req.setAttribute("alist", list);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "/list.jsp";
	}
}
