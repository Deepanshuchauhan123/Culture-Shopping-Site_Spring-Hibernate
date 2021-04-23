package com.deepanshu.ShoppingBackend.test;

import org.junit.BeforeClass;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.deepanshu.ShoppingBackend.dao.UserDAO;
import com.deepanshu.ShoppingBackend.dto.Address;
import com.deepanshu.ShoppingBackend.dto.Cart;
import com.deepanshu.ShoppingBackend.dto.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private Cart cart = null;
	private User user = null;
	private Address address = null;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.deepanshu.shoppingbackend");
		context.refresh();

		userDAO = (UserDAO) context.getBean("userDAO");
	}

}
