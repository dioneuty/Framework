package com.hb.controller;

import javax.servlet.http.HttpServletRequest;

import com.hb.engine.FrontImp;

public class AddController implements FrontImp {
	public String execute(HttpServletRequest req){
		return "/add.jsp";
	}
}
