package com.hb.day02.user.controller;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hb.day02.user.model.GuestUserDao;
import com.hb.day02.user.model.GuestUserVo;

@Controller
public class GuestUserController {
	private Logger log = Logger.getLogger(this.getClass());
	@Autowired
	private GuestUserDao<GuestUserVo> guestUserdao;
	
	@RequestMapping("/user/list")
	public void selectAll(Model model) {
		try {
			model.addAttribute("alist", guestUserdao.selectAll());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("user/detail")
	public void selectOne(Model model, @RequestParam("idx") int idx) {
		try {
			log.debug("detail start");
			model.addAttribute("bean", guestUserdao.selectOne(idx));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		log.debug("detail end");
	}
	
	@RequestMapping(value = "user/add", method = RequestMethod.GET)
	public String addForm() {
		return "user/form";
	}
	
	@RequestMapping(value = "user/add", method = RequestMethod.POST)
	public String insertOne(@ModelAttribute GuestUserVo bean) {
		log.debug(bean);
		try {
			guestUserdao.insertOne(bean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:list";
	}
}
