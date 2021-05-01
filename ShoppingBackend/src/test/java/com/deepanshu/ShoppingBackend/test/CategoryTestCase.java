package com.deepanshu.ShoppingBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.deepanshu.ShoppingBackend.config.HibernateConfig;
import com.deepanshu.ShoppingBackend.dao.CategoryDAO;
import com.deepanshu.ShoppingBackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();

		context.scan("com.deepanshu.ShoppingBackend");
		context.refresh();

		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
	}

	

	/*
	 * @Test public void testAddCategory() {
	 * 
	 * category = new Category();
	 * 
	 * category.setName("Television");
	 * category.setDescription("THis is desp of tv");
	 * category.setImageURL("url-img.jsp");
	 * 
	 * assertEquals("Successfully added a category inside the table!", true,
	 * categoryDAO.add(category));
	 * 
	 * }
	 */

	/*
	 * @Test public void testGetCategory() { category = categoryDAO.get(1);
	 * 
	 * assertEquals("Successfully fetched a category from the table!", "Television",
	 * category.getName());
	 * 
	 * }
	 */

	/*
	 * @Test public void testUpdateCategory() { category = categoryDAO.get(1);
	 * category.setName("TV");
	 * 
	 * assertEquals("Successfully updated a category in the table!", true,
	 * categoryDAO.update(category));
	 * 
	 * }
	 */

	/*
	 * @Test public void testDeleteCategory() { category = categoryDAO.get(1);
	 * 
	 * 
	 * assertEquals("Successfully Deleted a category in the table!", true,
	 * categoryDAO.delete(category));
	 * 
	 * }
	 */
	/*
	 * @Test public void testListCategory() {
	 * 
	 * assertEquals("Successfully Fetched list  of category from the table!", 1,
	 * categoryDAO.list().size());
	 * 
	 * }
	 */

	@Test
	public void testCRUDCategory() {

		// 1.adding new category
		category = new Category();

		category.setName("Laptop");
		category.setDescription("This is desp of Laptop");
		category.setImageURL("Laptop-img.jsp");

		assertEquals("Successfully added a category inside the table!", true, categoryDAO.add(category));

		category = new Category();

		category.setName("Television");
		category.setDescription("This is desp of television");
		category.setImageURL("television-img.jsp");

		assertEquals("Successfully added a category inside the table!", true, categoryDAO.add(category));

		
		
		// 2.fetching and updating category
		category = categoryDAO.get(2);
		category.setName("TV");

		assertEquals("Successfully updated a category in the table!", true, categoryDAO.update(category));

		
		
		// 3.deleting the category
		assertEquals("Successfully Deleted a category in the table!", true, categoryDAO.delete(category));

		
		
		// 4.fetching the list
		assertEquals("Successfully Fetched list  of category from the table!", 1, categoryDAO.list().size());

	}

}
