package com.hb.day01.test01;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;

public class Test3 {
	@RequestMapping("/ex03.do")
	public String myPage02(HttpServletRequest req){
		req.setAttribute("msg", "�� ���޵ǳ�?");
		return "ex01";
	}
//	public String myPage02(){
//		return "ex01";
//	}
}
