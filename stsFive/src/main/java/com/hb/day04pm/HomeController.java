package com.hb.day04pm;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hb.day04pm.model.dao.GuestDao;
import com.hb.day04pm.model.dto.GuestVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private GuestDao guestDao;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
				
		model.addAttribute("serverTime"
				, "<a href='guest/list'>link</a>" );
		
		return "home";
	}
	
	@RequestMapping("/guest/list")
	public void list(Model model){
		try {
			model.addAttribute("alist", guestDao.selectAll());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/guest/detail/{idx}")
	public ModelAndView one(@PathVariable int idx,ModelAndView mav){
		try {
			mav.addObject("bean", guestDao.selectOne(idx));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		mav.setViewName("guest/detail");
		return mav;
	}
	
	@RequestMapping(value="/guest/edit/{idx}",method=RequestMethod.GET)
	public ModelAndView edit(@PathVariable int idx,ModelAndView mav){
		try {
			mav.addObject("bean", guestDao.selectOne(idx));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		mav.setViewName("guest/edit");
		return mav;
	}
	
	@RequestMapping(value="/guest/edit/{idx}",method=RequestMethod.POST)
	public String update(@PathVariable int idx,@ModelAttribute GuestVo bean){
		try {
			guestDao.updateOne(bean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:../detail/"+idx;
	}
	
	@RequestMapping(value="/guest/add",method=RequestMethod.GET)
	public void add(){}
		
	@RequestMapping(value="/guest/add",method=RequestMethod.POST)
	public String insert(@ModelAttribute GuestVo bean){
		try {
			guestDao.insertOne(bean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:list";
	}
	
	@RequestMapping("/guest/del/{idx}")
	public String deletePage(@PathVariable int idx ){
		try {
			guestDao.deleteOne(idx);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:../list";
	}
}
