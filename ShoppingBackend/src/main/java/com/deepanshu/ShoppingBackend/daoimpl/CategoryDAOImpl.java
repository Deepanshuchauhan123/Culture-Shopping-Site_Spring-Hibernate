package com.deepanshu.ShoppingBackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import com.deepanshu.ShoppingBackend.dao.CategoryDAO;
import com.deepanshu.ShoppingBackend.dto.Category;

public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();

	static {
		Category category = new Category();

		category.setId(1);
		category.setName("Television");
		category.setDescription("THis is desp of tv");
		category.setImageURL("url-img.jsp");

		categories.add(category);

		category = new Category();

		category.setId(1);
		category.setName("Mobile");
		category.setDescription("THis is desp of Mobile");
		category.setImageURL("url-img.jsp");

		categories.add(category);
		category = new Category();

		category.setId(1);
		category.setName("lapi");
		category.setDescription("THis is desp of lapi");
		category.setImageURL("url-img.jsp");

		categories.add(category);
		category = new Category();

		category.setId(1);
		category.setName("books");
		category.setDescription("THis is desp of books");
		category.setImageURL("url-img.jsp");

		categories.add(category);
	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

}
