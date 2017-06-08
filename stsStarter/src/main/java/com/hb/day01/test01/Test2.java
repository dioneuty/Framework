package com.hb.day01.test01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Test2 {
	
	@RequestMapping("/ex02")
	public ModelAndView myPage01(){
		ModelAndView mav = new ModelAndView();
		return mav;
	}
}