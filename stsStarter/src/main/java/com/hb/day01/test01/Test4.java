package com.hb.day01.test01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test4 {
	@RequestMapping("/ex04")
	public String myPage01(Model model){
		model.addAttribute("msg","¸ðµ¨·Î Àü´Þ");
		return "ex02";
	}
	@RequestMapping("/ex05")
	public String myPage02(){
		return "ex01";
	}
	@RequestMapping("/ex06")
	public void myPage03(){
	}
	public String myPage04(){
		return "ex07";
	}
	
}
