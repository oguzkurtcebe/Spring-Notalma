package com.oguzkurtcebe.notalma;

import java.beans.PropertyVetoException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest req) {

		System.out.println(req.getRemoteAddr());
		model.addAttribute("serverTime", "/");

		return "index";
	}

	
	@RequestMapping(value = "/detay", method = RequestMethod.GET)
	public String home(Model model)  {
	


		return "detail";
	}

	@RequestMapping(value = "/error_404", method = RequestMethod.GET)
	public String error(Model model) {

		return "error_404";
	}
}
