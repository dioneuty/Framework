package com.hb.day04.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hb.day04.model.dao.GuestDao;
import com.hb.day04.model.dto.GuestVo;

@Controller
public class GuestController {
	@Autowired
	private GuestDao guestDao;

	@RequestMapping("guest/list")
	public void selectAll(Model model){
		try {
			model.addAttribute("alist", guestDao.selectAll());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value="guest/add",method=RequestMethod.GET)
	public void addForm(){
	}
	@RequestMapping(value="guest/add",method=RequestMethod.POST)
	public String insertOne(@ModelAttribute GuestVo bean){
		try {
			guestDao.insertOne(bean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:list";
	}
}