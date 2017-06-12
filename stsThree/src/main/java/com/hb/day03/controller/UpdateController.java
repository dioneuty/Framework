package com.hb.day03.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hb.day03.model.dao.GuestDao;
import com.hb.day03.model.dto.GuestVo;

@Controller
public class UpdateController {
	@Autowired
	private GuestDao guestDao;
	
	@RequestMapping(value="/guest", method=RequestMethod.GET)
	public String addForm(){
		return "form";
	}
	@RequestMapping(value="/guest", method=RequestMethod.POST)
	public String insertOne(@ModelAttribute GuestVo bean){
		try {
			guestDao.insertOne(bean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:list";
	}
	
}
