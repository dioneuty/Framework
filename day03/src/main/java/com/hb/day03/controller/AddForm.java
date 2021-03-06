package com.hb.day03.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.day03.support.MyController;

public class AddForm implements MyController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("title", "입력");
		req.setAttribute("nxtURI", "insert.do");
		return "form";
	}
	
}
