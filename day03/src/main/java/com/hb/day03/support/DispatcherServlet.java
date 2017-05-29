package com.hb.day03.support;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet{
	@Override
	public void init() throws ServletException {
		super.init();
		
		HandlerMapping.setMap("/main.do", "com.hb.day03.controller.SelectAll");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//controller
		String uri = req.getRequestURI();
		MyController controller = HandlerMapping.mapping(uri);
		String path = controller.execute(req, resp);
		
		//view
		if(path.startsWith("redirect:")){
			path = path.replace("redirect:", "");
			resp.sendRedirect(path);
			return;
		}
		
		String prefix = "";
		String surfix = ".jsp";
		req.getRequestDispatcher(prefix + path + surfix).forward(req, resp);
	}
}
