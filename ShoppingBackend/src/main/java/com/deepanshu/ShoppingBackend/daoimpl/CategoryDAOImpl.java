package com.deepanshu.ShoppingBackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.deepanshu.ShoppingBackend.dao.CategoryDAO;
import com.deepanshu.ShoppingBackend.dto.Category;

@Repository("categoryDAO")
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

		category.setId(2);
		category.setName("Mobile");
		category.setDescription("This is desp of Mobile");
		category.setImageURL("url-img.jsp");

		categories.add(category);
		category = new Category();

		category.setId(3);
		category.setName("Laptop");
		category.setDescription("THis is desp of lapi");
		category.setImageURL("url-img.jsp");

		categories.add(category);
		category = new Category();

		category.setId(4);
		category.setName("Books");
		category.setDescription("THis is desp of books");
		category.setImageURL("url-img.jsp");

		categories.add(category);
	}

	@Override
	public List<Category> list() {

		return categories;
	}

	@Override
	public Category get(int id) {
		
		// enhanced for loop

		for (Category category : categories) {
			if (category.getId() == id)
				return category;
		}
		return null;
	}

}