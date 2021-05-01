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
		context.scan("com.deepanshu.ShoppingBackend");
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

		address = new Address();
		address.setAddressLineOne("B-528, Ganpati Vihar");
		address.setAddressLineTwo("Tijara Phatak");
		address.setCity("Alwar");
		address.setState("Rajasthan");
		address.setCountry("India");
		address.setPostalCode("301001");
		address.setBilling(true);

		// link the user with the address using user id
		address.setUserId(user.getId());

		assertEquals("Failed to add address!", true, userDAO.addAdress(address));

		if (user.getRole().equals("USER")) {
			// create a cart for this user
			cart = new Cart();
			cart.setUser(user);

			// add the cart
			assertEquals("Failed to add cart!", true, userDAO.addCart(cart));

			// add a shipping address for this user

			address = new Address();
			address.setAddressLineOne("B-528, Ganpati Vihar");
			address.setAddressLineTwo("Tijara Phatak");
			address.setCity("Alwar");
			address.setState("Rajasthan");
			address.setCountry("India");
			address.setPostalCode("301001");
			// set shipping trrue
			address.setShipping(true);

			// link it with the user
			address.setUserId(user.getId());

			assertEquals("Failed to add shipping address!", true, userDAO.addAdress(address));

		}

	}

}
