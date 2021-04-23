package com.deepanshu.ShoppingBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
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

	@Test
	public void testAdd() {
		user = new User();
		user.setFirstName("Anshu");
		user.setLastName("Chauhan");
		user.setEmail("abc@gmail.com");
		user.setContactNumber("1234567890");
		user.setRole("USER");
		user.setPassword("123456");

		// add the user
		assertEquals("failed to add user!", true, userDAO.addUser(user));

	}

}
