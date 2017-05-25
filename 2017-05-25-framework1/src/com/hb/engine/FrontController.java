package com.hb.engine;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.model.SampleDao;

//web.xml에 서블릿 정의
public class FrontController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = "/";
		String fPath = req.getRequestURI();
		String cPath = req.getContextPath();
		
		System.out.println(req.getRequestURI());
		
		try {
			SampleDao dao = new SampleDao();

			if(fPath.equals(cPath+"/list.do")){
				url+="/list";
				List list = dao.selectAll();
				req.setAttribute("alist", list);
			}else if(fPath.equals(cPath+"/add.do")){
				url+="/add";
			}else if(fPath.equals(cPath+"/detail.do")){
				url+="/detail";
				Map<String,Object>map = dao.selectOne(Integer.parseInt(req.getParameter("idx")));
				req.setAttribute("bean", map);
			}else{
				url+="/index";
			}
			url+=".jsp";
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		//view
		req.getRequestDispatcher(url).forward(req, resp);
	}
}
