/**
 * 
 */
package com.i2i.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.i2i.model.Category;
import com.i2i.model.Subcategory;
import com.i2i.service.CategoryService;
import com.i2i.dao.SubcategoryDao;
import com.i2i.exception.ApplicationException;
/**
 * @author Kumar Albert
 *
 * version 1.0
 * 
 */
/**
 * @author Kumar Albert
 *
 * version 1.0
 * 
 */

@Service("subcategoryService")
public class SubcategoryService {
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	SubcategoryDao subcategoryDao;

	
	/**
	 * @param name
	 * @param createdBy
	 * @param createdAt
	 * @param modifiedBy
	 * @param modifiedAt
	 * @return boolean
	 *             If Boolean value is true , record added successfully. Otherwise record didn't added.
	 */
	public boolean addSubcategory(String categoryName,String subcategoryName , int createdBy) throws ApplicationException {
		Category category = categoryService.findCategoryByName(categoryName);
        Timestamp createdAt = new java.sql.Timestamp(new java.util.Date().getTime());
        Timestamp modifiedAt = null;
        int modifiedBy = 0;
		Subcategory subcategory = new Subcategory(subcategoryName, category, createdBy, createdAt, modifiedBy, modifiedAt);
		return subcategoryDao.insertSubcategory(subcategory);
	}
	
	
	/**
	 * @return List<Subcategory>
	 *            It return Subcategory details.
	 */
	public List<Subcategory> getSubcategoryDetails() throws ApplicationException {
		return subcategoryDao.retrieveSubcategoryDetails();		
	}
	
	/**
	 * @param name
	 * @return Subcategory
	 *             Subcategory holds required subcategory details.
	 */
	public Subcategory findSubcategoryByName(String name) throws ApplicationException{
		return subcategoryDao.searchSubcategoryByName(name);
	}
	
	
	/**
	 * @param oldName
	 * @param newName
	 * @param modifiedBy
	 * @param modifiedAt
	 * @return boolean
	 *             If Boolean value is true , record modified successfully. Otherwise record didn't modified.
	 */
	public boolean modifySubcategoryNameByName(String oldName, String newName, int modifiedBy) throws ApplicationException {
		Subcategory subcategory = subcategoryDao.searchSubcategoryByName(oldName);
		subcategory.setName(newName);
        Timestamp modifiedAt = new java.sql.Timestamp(new java.util.Date().getTime());
        subcategory.setModifiedBy(modifiedBy);
        subcategory.setModifiedAt(modifiedAt);
		return subcategoryDao.updateSubcategory(subcategory);
	}
	
	/**
	 * @param name
	 * @return boolean
	 *             If Boolean value is true , record removed successfully. Otherwise record didn't removed.
	 */
	public boolean removeSubcategoryByName(String name) throws ApplicationException {
		Subcategory subcategory = subcategoryDao.searchSubcategoryByName(name);
		return subcategoryDao.deleteSubcategory(subcategory);
	}

}