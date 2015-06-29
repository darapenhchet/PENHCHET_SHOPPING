package com.penhchet.shopping.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.penhchet.shopping.HomeController;
import com.penhchet.shopping.model.Product;
import com.penhchet.shopping.service.ProductDAO;
import com.penhchet.shopping.service.ProductDAOImp;

@Controller
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/products/add", method = RequestMethod.GET)
	public String addNewProduct(Locale locale, Model model) {
		logger.info("Welcome to /products/add! The client locale is {}.", locale);
		ProductDAO productDAO = new ProductDAOImp();
		Product product = new Product();
		product.setId(new Long(2));
		product.setProductName("PEPSI...");
		productDAO.registerNewProduct(product);
		return "home";
	}
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String selectAllProducts(Locale locale, Model model) {
		logger.info("Welcome to /products/! The client locale is {}.", locale);
		ProductDAO productDAO = new ProductDAOImp();
		List<Product> products = productDAO.selectAllProducts();
		return "home";
	}
}
