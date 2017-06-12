package com.hb.day03.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hb.day03.model.dao.GuestDao;

/* 
 * 레스트풀
 * 목록   /list    	get

		입력폼 /guest 		get
		입력   /guest		post

		상세   /guest/{1} 	get
		수정   /guest/{1} 	put
		삭제   /guest/{1}   delete
 */

@Controller
public class SelectController {
	@Autowired
	private GuestDao guestDao;
	
	@RequestMapping("/list")
	public ModelAndView selectAll(ModelAndView mav) {
		try {
			mav.addObject("alist", guestDao.selectAll());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		mav.setViewName("list");
		return mav;
	}
	@RequestMapping(value="/guest/{idx}", method=RequestMethod.GET)
	public String selectOne(@PathVariable int idx, Model model) {
		try {
			model.addAttribute("bean", guestDao.selectOne(idx));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "detail";
	}
}
