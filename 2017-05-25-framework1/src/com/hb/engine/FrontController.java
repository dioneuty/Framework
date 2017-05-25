package com.hb.engine;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.controller.AddController;
import com.hb.controller.DetailController;
import com.hb.controller.InsertController;
import com.hb.controller.ListController;
import com.hb.model.SampleDao;

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
		String url = null;
		String fPath = req.getRequestURI();
		String cPath = req.getContextPath();
		
		System.out.println(req.getRequestURI());
		
		try {
			SampleDao dao = new SampleDao();

			if(fPath.equals(cPath + "/list.do")){
				ListController lCon = new ListController();
				url = lCon.execute(req);
			}else if(fPath.equals(cPath + "/add.do")){
				AddController aCon = new AddController();
				url = aCon.execute(req);
			}else if("POST".equals(req.getMethod()) && fPath.equals(cPath + "/insert.do")){
				InsertController iCon = new InsertController();
				url = iCon.execute(req);
			}else if(fPath.equals(cPath + "/detail.do")){
				DetailController dCon = new DetailController();
				url = dCon.execute(req);
			}else{
				url = "/index.jsp";
			}
			dao.closeAll();
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		//view
		req.getRequestDispatcher(url).forward(req, resp);
	}
}
