package com.hb.day05am;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hb.day05am.model.GuestDao;

@Controller
public class HomeController {
	@Autowired
	private SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		return "home";
	}
	@RequestMapping("/guest/list")
	public void listPage(Model model) {
		GuestDao dao = sqlSession.getMapper(GuestDao.class);
		try {
			model.addAttribute("alist", dao.selectAll());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
