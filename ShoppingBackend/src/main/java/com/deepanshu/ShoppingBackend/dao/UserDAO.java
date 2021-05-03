package com.deepanshu.ShoppingBackend.dao;

import com.deepanshu.ShoppingBackend.dto.Address;
import com.deepanshu.ShoppingBackend.dto.Cart;
import com.deepanshu.ShoppingBackend.dto.User;

public interface UserDAO {

	//add a user
	boolean addUser(User user);
	
	//getting by email
	User getByEmail(String email);
	
	//add an address
	boolean addAdress(Address address);
	
	//add a cart
	boolean updateCart(Cart cart);
}
