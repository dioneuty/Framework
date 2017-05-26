package com.hb.engine;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.controller.AddController;
import com.hb.controller.DetailController;
import com.hb.controller.InsertController;
import com.hb.controller.ListController;
import com.hb.controller.UpdateController;

//web.xml에 서블릿 정의
public class FrontController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doDo(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		doDo(req, resp);
	}

	protected void doDo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = "";
		String fPath = req.getRequestURI();
		String cPath = req.getContextPath();
		
		System.out.println(req.getRequestURI());
		
		FrontImp controller = null;

		if(fPath.equals(cPath + "/list.do")){
			controller = new ListController();
			
		}else if(fPath.equals(cPath + "/add.do")){
			controller = new AddController();
		}else if("POST".equals(req.getMethod()) && fPath.equals(cPath + "/insert.do")){
			controller = new InsertController();
		}else if("POST".equals(req.getMethod()) && fPath.equals(cPath + "/update.do")){
			controller = new UpdateController();
		}else if(fPath.equals(cPath + "/detail.do")){
			controller = new DetailController();
		}
		
		if(controller != null){
			url=controller.execute(req);			
		}
		//view
		req.getRequestDispatcher(url).forward(req, resp);
	}
}
