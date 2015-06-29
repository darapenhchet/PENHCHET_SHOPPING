package com.penhchet.shopping;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.penhchet.shopping.utils.HibernateUtil;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		logger.info("Welcome Admin Page! The client locale is {}.", locale);
		
		return "admin/user-login";
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin(Locale locale, Model model) {
		logger.info("Welcome Admin Page! The client locale is {}.", locale);
		
		return "admin/index";
	}
	
	@RequestMapping(value = "/comingsoon", method = RequestMethod.GET)
	public String comingSoon(Locale locale, Model model) {
		logger.info("Welcome Admin Page! The client locale is {}.", locale);
		
		return "admin/pages-coming-soon";
	}
	
	@RequestMapping(value = "/connection", method = RequestMethod.GET)
	public String connection(Locale locale, Model model) {
		try{
			logger.info("Welcome Admin Page! The client locale is {}.", locale);
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.close();
			System.out.println("Successfully!!!");
			System.out.println("Successfully!!!");
			System.out.println("Successfully!!!");
			System.out.println("Successfully!!!");
			System.out.println("Successfully!!!");
			System.out.println("Successfully!!!");
			System.out.println("Successfully!!!");
			System.out.println("Successfully!!!");
		}catch(Exception ex){
			
		}
		return "admin/pages-coming-soon";
	}
}
