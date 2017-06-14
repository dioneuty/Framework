package com.hb.day05am;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hb.day05am.model.GuestDao;
import com.hb.day05am.model.GuestVo;
import com.hb.day05am.service.ServiceCommand;
import com.hb.day05am.service.ServiceImpl;

@Controller
public class HomeController {
	@Autowired
	ServiceCommand service; /*= new ServiceImpl()*/
	@Autowired
	private SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	@RequestMapping("/guest/list")
	public void listPage(Model model) throws SQLException {
		service.listService(sqlSession, model);
		/*GuestDao dao = sqlSession.getMapper(GuestDao.class);
		try {
			model.addAttribute("alist", dao.selectAll());
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
	}
	
	@RequestMapping(value="/guest/add",method=RequestMethod.GET)
	public void addPage(){}
		
	@RequestMapping(value="/guest/add",method=RequestMethod.POST)
	public String insertPage(@Valid GuestVo bean, BindingResult br, Model model) throws SQLException{
		if(br.hasErrors()){
			List<ObjectError> err = br.getAllErrors();
			for (int i = 0; i < err.size(); i++) {
//				System.out.println(err.get(i).getDefaultMessage());
//				model.addAttribute("bean", err.get(i).getDefaultMessage());
				System.out.println(err.get(i).getCodes()[1]);
				Map<String, String> errMsg = new HashMap<String, String>();
				
				if("typeMismatch.sabun".equals(err.get(i).getCodes()[1])){
					errMsg.put("sabun", "사번이 비었습니다.");
				}else if("typeMismatch.pay".equals(err.get(i).getCodes()[1])){
					errMsg.put("pay", "금액이 비었습니다.");
				}else if("Email.name".equals(err.get(i).getCodes()[1])){
					errMsg.put("name", "이메일 형식이 아닙니다.");
				}else if("Size.name".equals(err.get(i).getCodes()[1])){
					errMsg.put("name", "이메일 형식이 아니거나 비었습니다.");
				}
				
				model.addAttribute("bean", bean);
				model.addAttribute("err", errMsg);
			}
			return "guest/add";
		}
		service.addService(sqlSession, bean);
		/*GuestDao dao = sqlSession.getMapper(GuestDao.class);
		try {
			dao.insertOne(bean);
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		return "redirect:list";
	}
	
	@RequestMapping("/guest/detail/{idx}")
	public String detailPage(@PathVariable int idx,Model model) throws SQLException{
		service.detailService(sqlSession, model, idx);
		/*GuestDao dao = sqlSession.getMapper(GuestDao.class);
		try {
			model.addAttribute("bean", dao.selectOne(idx));
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		return "guest/detail";
	}
	
	@RequestMapping(value="/guest/edit/{idx}",method=RequestMethod.GET)
	public String editPage(@PathVariable int idx,Model model) throws SQLException{
		service.detailService(sqlSession, model, idx);
		/*GuestDao dao = sqlSession.getMapper(GuestDao.class);
		try {
			model.addAttribute("bean", dao.selectOne(idx));
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		return "guest/edit";
	}
	
	@RequestMapping(value="/guest/edit/{idx}",method=RequestMethod.POST)
	public String updatePage(@PathVariable int idx,@ModelAttribute GuestVo bean) throws SQLException{
		service.editService(sqlSession, bean);
		/*GuestDao dao = sqlSession.getMapper(GuestDao.class);
		try {
			dao.updateOne(bean);
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		return "redirect:../detail/"+idx;
	}
	
	@RequestMapping("/guest/del/{idx}")
	public String delete(@PathVariable int idx ) throws SQLException{
		service.deleteService(sqlSession, idx);
		/*GuestDao dao = sqlSession.getMapper(GuestDao.class);
		try {
			dao.deleteOne(idx);
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		return "redirect:../list";
	}
}
