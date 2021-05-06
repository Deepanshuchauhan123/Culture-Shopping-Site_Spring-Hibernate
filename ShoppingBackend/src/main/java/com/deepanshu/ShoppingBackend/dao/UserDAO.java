package com.deepanshu.ShoppingBackend.dao;

import java.util.List;

import com.deepanshu.ShoppingBackend.dto.Address;
import com.deepanshu.ShoppingBackend.dto.Cart;
import com.deepanshu.ShoppingBackend.dto.User;

public interface UserDAO {

	// add a user
	boolean addUser(User user);

	// getting by email
	User getByEmail(String email);

	// add an address
	boolean addAdress(Address address);

	Address getBillingAddress(User user);

	List<Address> listShippingAddresses(User user);

	// add a cart
	boolean updateCart(Cart cart);
}
