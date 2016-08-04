/**
 * 
 */
package com.i2i.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.i2i.model.Category;
import com.i2i.dao.CategoryDao;
import com.i2i.exception.ApplicationException;
/**
 * @author Kumar Albert
 *
 * version 1.0
 * 
 */
@Service("categoryService")
public class CategoryService {
	
	@Autowired
	CategoryDao categoryDao;

	public void addCategory(String name, int createdBy) throws ApplicationException{
        Timestamp createdAt = new java.sql.Timestamp(new java.util.Date().getTime());
        Timestamp modifiedAt = null;
        int modifiedBy = 0;
		Category category = new Category(name, createdBy, createdAt, modifiedBy, modifiedAt);
		categoryDao.insertCategory(category);
	}
	
	public List<Category> getCategoryDetails() throws ApplicationException {
		System.out.println("Inside Service");
		return categoryDao.retrieveCategoryDetails();		
	}
	
	public Category findCategoryByName(String name) throws ApplicationException{
		return categoryDao.searchCategoryByName(name);
	}
	
	public boolean modifyCategoryNameByName(String oldName, String newName, int modifiedBy) throws ApplicationException {
		Category category = categoryDao.searchCategoryByName(oldName);
		category.setName(newName);
        Timestamp modifiedAt = new java.sql.Timestamp(new java.util.Date().getTime());
		category.setModifiedBy(modifiedBy);
		category.setModifiedAt(modifiedAt);
		return categoryDao.updateCategory(category);
	}
	
	public boolean removeCategoryByName(String name) throws ApplicationException {
		Category category = categoryDao.searchCategoryByName(name);
		return categoryDao.deleteCategory(category);
	}
}