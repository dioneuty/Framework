package com.hb.day01.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hb.day01.model.SimpleDao;

@Controller
public class SimpleController {
	@Autowired
	private SimpleDao dao;
	
	/*public void setDao(SimpleDao dao) {
		this.dao = dao;
	}*/
	
	/*public SimpleController() {
		this.dao = new SimpleDao();
	}*/
	
	@RequestMapping("/list")
	public String list(Model model) {
		try {
			model.addAttribute("alist", dao.selectAll());
		} catch (SQLException e) {
			System.out.println("Dao 문제");
		}
		
		return "simple/list";
	}
	
	@RequestMapping("/add")
	public String addForm(){
		return "simple/add";
	}

	@RequestMapping("/insert")
	public String insertOne(int sabun, String name, int pay) {
		try {
			dao.insertOne(sabun,name,pay);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:list";
	}
	
	//래스트 풀
	@RequestMapping("detail/{num}")
	public String detailOne(Model model, @PathVariable int num) {
		try {
			model.addAttribute("bean",dao.detailOne(num));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "simple/detail";
	}
	
	@RequestMapping("edit/{num}")
	public String editForm(@PathVariable int num, Model model) {
		try {
			model.addAttribute("bean",dao.detailOne(num));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "simple/edit";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateOne(int sabun, String name, int pay) {
		int result = 0;
		try {
			result = dao.updateOne(sabun,name,pay);
		} catch (SQLException e) {
		}
		if(result > 0)
			return "redirect:list";
		else
			return "redirect:edit/"+sabun;
	}
	
	@RequestMapping("/del/{num}")
	public String delete(@PathVariable int num) {
		int result = 0;
		try {
			result = dao.deleteOne(num);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(result > 0)
			return "redirect:./../list";
		else
			return "redirect:./../detail/"+num;
	}
}
