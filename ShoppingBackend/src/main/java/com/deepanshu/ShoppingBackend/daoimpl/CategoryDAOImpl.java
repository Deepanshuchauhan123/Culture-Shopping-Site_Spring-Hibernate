package com.deepanshu.ShoppingBackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.deepanshu.ShoppingBackend.dao.CategoryDAO;
import com.deepanshu.ShoppingBackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Category> list() {

		return null;
	}

	/*
	 * Getting single Category based on id
	 */
	@Override
	public Category get(int id) {

		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override
	public boolean add(Category category) {
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().persist(category);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	/*
	 * updating single category
	 * 
	 * @see com.deepanshu.ShoppingBackend.dao.CategoryDAO#update(com.deepanshu.
	 * ShoppingBackend.dto.Category)
	 */
	@Override
	public boolean update(Category category) {

		try {

			sessionFactory.getCurrentSession().update(category);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {

		category.setActive(false);
		try {

			sessionFactory.getCurrentSession().update(category);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
