package com.hb.maven.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hb.maven.model.SimpleDao;
import com.hb.maven.model.SimpleVo;
import com.hb.maven.support.MyController;

public class InsertController implements MyController{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//해커가 get방식으로 입력하지 못하게 post가 아니면 다시 되돌리는 방식
		if(!"POST".equals(request.getMethod())){
			request.setAttribute("msg", "잘못된 접근입니다");
			return "form";
		}
		Map<String,String> errs = new HashMap<>();
		String param1 = request.getParameter("name");
		String param2 = request.getParameter("nalja");
		String param3 = request.getParameter("pay");
		SimpleVo vo = new SimpleVo();
		vo.setName(param1);
		vo.setNalja(param2);
		//pay를 입력하지 않을 경우 form페이지로 돌아가는 방식
		try{
			vo.setPay(Integer.parseInt(param3));
		}catch(Exception e){
//			request.setAttribute("errPay", "pay의 입력 확인");
//			request.setAttribute("bean",  vo);
//			return "form";
			errs.put("pay", "금액 입력");
		}
		if(param1.equals("")){
//			request.setAttribute("errNm", "빈칸입력");
//			request.setAttribute("bean",  vo);
//			return "form";
			errs.put("name", "이름 입력");
		}
		if(param2.equals("")){
//			request.setAttribute("errNL", "날짜입력");
//			request.setAttribute("bean",  vo);
//			return "form";
			errs.put("nalja", "날짜 입력");
		}
		
		if(!errs.isEmpty()){
			request.setAttribute("bean", vo);
			request.setAttribute("err", errs);
			return "form";
		}
		
		SimpleDao dao = new SimpleDao();
		int result = 0;
		try {
			result = dao.insertOne(vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result>0){
			return "redirect:list.do";			
		}else{
			return "form";
		}
	}

}
