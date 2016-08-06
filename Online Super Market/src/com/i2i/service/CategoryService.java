package com.i2i.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.i2i.model.Category;
import com.i2i.dao.CategoryDao;
import com.i2i.exception.ApplicationException;
/**
 * <h1> Category Service </h1>
 * <p> Category Service provides category related services.</p>
 * 
 * @author Kumar Albert
 *
 * version 1.0
 */

@Service("categoryService")
public class CategoryService {
	
	@Autowired
	CategoryDao categoryDao;

	/** 
	 * <p> This method used to add category </p>
	 * @param name It holds category name.
	 * @param createdBy It holds id of who create this category.
	 * @return boolean This returns true, if operation successfully done.
	 * 					Otherwise it returns false. 
	 * @throws ApplicationException
	 */
	public boolean addCategory(String name, int createdBy) throws ApplicationException{
        Timestamp createdAt = new java.sql.Timestamp(new java.util.Date().getTime());
        Timestamp modifiedAt = null;
        int modifiedBy = 0;
		Category category = new Category(name, createdBy, createdAt, modifiedBy, modifiedAt);
		return categoryDao.insertCategory(category);
	}
	
	/**
	 * <p> This method used to get category details </p>
	 * @return List. It returns list of category.
	 * @throws ApplicationException
	 */
	public List<Category> getCategoryDetails() throws ApplicationException {
		System.out.println("Inside Service");
		return categoryDao.retrieveCategoryDetails();		
	}
	
	/**
	 * <p> This method is used to find category details </p>
	 * @param name It holds category's name.
	 * @return Category It returns category object. 
	 * @throws ApplicationException
	 */
	public Category findCategoryByName(String name) throws ApplicationException{
		return categoryDao.searchCategoryByName(name);
	}
	
	/**
	 * <p> This method used to modify category details. </p>
	 * @param oldName It holds category's old name.
	 * @param newName It holds category's new name.
	 * @param modifiedBy It holds id of who create this category.
	 * @return boolean This returns true, if operation successfully done.
	 * 					Otherwise it returns false.
	 * @throws ApplicationException
	 */
	public boolean modifyCategoryNameByName(String oldName, String newName, int modifiedBy) throws ApplicationException {
		Category category = categoryDao.searchCategoryByName(oldName);
		category.setName(newName);
        Timestamp modifiedAt = new java.sql.Timestamp(new java.util.Date().getTime());
		category.setModifiedBy(modifiedBy);
		category.setModifiedAt(modifiedAt);
		return categoryDao.updateCategory(category);
	}
	
	/**
	 * <p> This method used to delete category</p>
	 * @param name It holds category's name.
	 * @return boolean This returns true, if operation successfully done.
	 * 					Otherwise it returns false.
	 * @throws ApplicationException
	 */
	public boolean removeCategoryByName(String name) throws ApplicationException {
		Category category = categoryDao.searchCategoryByName(name);
		return categoryDao.deleteCategory(category);
	}
}