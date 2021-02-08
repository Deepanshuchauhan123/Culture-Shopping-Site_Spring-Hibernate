package com.deepanshu.OnlineShopping.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.deepanshu.ShoppingBackend.dao.CategoryDAO;
import com.deepanshu.ShoppingBackend.dao.ProductDAO;
import com.deepanshu.ShoppingBackend.dto.Category;
import com.deepanshu.ShoppingBackend.dto.Product;

@Controller
@RequestMapping("/manage")
public class ManagementController {

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private ProductDAO productDAO;

	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name = "operation", required = false) String operation) {
		ModelAndView mv = new ModelAndView("page");

		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");
		Product nProduct = new Product();

		// set few new fields

		nProduct.setSupplierId(1);
		nProduct.setActive(true);

		mv.addObject("product", nProduct);

		if (operation != null) {
			if (operation.equals("product")) {
				mv.addObject("message", "Product Submitted Successfully!");
			}
		}

		return mv;
	}

	// handling product submission
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct, BindingResult results,
			Model model) {

		// check if their is any errors

		if (results.hasErrors()) {

			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title", "Manage Products");
			model.addAttribute("message", "Validation failed for Product Submission!");
			return "page";
		}

		logger.info(mProduct.toString());
		// create a new product record
		productDAO.add(mProduct);

		return "redirect:/manage/products?operation=product";

	}

	// returning all categories on request
	@ModelAttribute("categories")
	public List<Category> getCategories() {
		return categoryDAO.list();
	}
}
