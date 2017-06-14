package com.hb.day05pm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	String path="C:\\libraries\\";
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	@RequestMapping(value="/add")
	public String form() {
		return "upform";
	}
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public String upload(@RequestParam("sabun") int sabun, @RequestParam("file") MultipartFile file , Model model) {
		logger.debug(file.getOriginalFilename());
		
		File f = new File(path+file.getOriginalFilename());
		try {
			file.transferTo(f);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("fname", file.getOriginalFilename());
		return "result";
	}
	@RequestMapping("/download")
	public void donwload(@RequestParam("file") String file, HttpServletResponse res) {
		File f = new File(path+file);
		res.setContentType("application/octet-stream);charset=UTF-8");
		res.setHeader("content-Disposition", "attachment; filename= \" "+file+" \" ");
		try {
			FileInputStream fis = new FileInputStream(f); 
			OutputStream out = res.getOutputStream();
			FileCopyUtils.copy(fis, out);
		} catch (IOException e) {
			e.printStackTrace();
		}
				
	}
}
