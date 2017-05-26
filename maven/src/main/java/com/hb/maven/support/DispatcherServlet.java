package com.hb.maven.support;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.maven.controller.AddController;
import com.hb.maven.controller.InsertController;
import com.hb.maven.controller.ListController;

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		//HandlerMapping.setMap("/maven/*.do", "com.hb.maven.controller.ListController");
		HandlerMapping.setMap("/maven/list.do", "com.hb.maven.controller.ListController");
		HandlerMapping.setMap("/maven/add.do", "com.hb.maven.controller.AddController");
		HandlerMapping.setMap("/maven/insert.do", "com.hb.maven.controller.InsertController");
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 도메인 설계
		// /list.do     get 	->  /page/list.jsp   -> list
		// /detail.do   get 	->  /page/detail.jsp -> detail
		// /add.do      get 	->  /page/form.jsp   -> form
		// /insert.do  post ->  redirect: list.do    -> redirect: list.do
		// /edit.do     get 	->  /page/form.jsp 재사용
		// /update.do  post ->  redirect: detail.do
		// /del.do     post ->  redirect: detail.do
		
		// controller 선택
		String uri = request.getRequestURI();
		MyController controller = HandlerMapping.mapping(uri);
		String pname = controller.execute(request, response);
		
		// view
		String url = null;
		if(pname.startsWith("redirect:")){
			url = pname.replace("redirect:", "");
			response.sendRedirect(url);
			return;
		}
		
		String prefix = "/page/";
		String surfix = ".jsp";
		url = prefix + pname + surfix;
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
