package com.hb.day01.test01;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	@RequestMapping("/ex07")
	public String myPage04(Model model, HttpServletRequest req) {
		System.out.println(req.getParameter("msg"));
		model.addAttribute("msg", req.getParameter("msg"));
		return "ex07";
	}
	@RequestMapping("/ex08")
	public String myPage05(@RequestParam("msg") String msg){
		System.out.println(msg);
		return "ex08";
	}
	@RequestMapping("path/{a}")
	public String myPage06(@PathVariable String a) {
		System.out.println("a:" + a);
		return "ex01";
	}
	@RequestMapping("/ex09")
	public String myPage09(){
		return "ex02";
	}
	@RequestMapping(value = "/ex10", method = RequestMethod.POST)
	public String myPage10(String id, String pw) {
		System.out.println("id: " + id + ", pw: " + pw);
		return "ex03";
	}
	
}
