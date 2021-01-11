package com.deepanshu.ShoppingBackend.dao;

import java.util.List;

import com.deepanshu.ShoppingBackend.dto.Category;

public interface CategoryDAO {

	List<Category> list();

	Category get(int id);
}
