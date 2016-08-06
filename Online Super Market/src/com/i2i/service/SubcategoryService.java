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
 * <h1> Subcategory Service</h1>
 * <p> It provide subcategory related services </p>
 * 
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
	 * <p> This method used to add subcategory.</p>
	 * @param categoryName It holds category name.
	 * @param subcategoryName It holds subcategory name.
	 * @param createdBy It holds id of who create subcategory record.
	 * @return boolean If Boolean value is true , record added successfully. 
	 * 					Otherwise record not added.
	 * @throws ApplicationException
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
	 * <p> This method used to get subcategory list.</p>
	 * @return List It returns subcategory list. 
	 * @throws ApplicationException
	 */
	public List<Subcategory> getSubcategoryDetails() throws ApplicationException {
		return subcategoryDao.retrieveSubcategoryDetails();		
	}
	

	/**
	 * <p> This method used to find subcategory.</p>
	 * @param name It holds subcategory name.
	 * @return subcategory It returns subcategory object.
	 * @throws ApplicationException
	 */
	public Subcategory findSubcategoryByName(String name) throws ApplicationException{
		return subcategoryDao.searchSubcategoryByName(name);
	}
	
	
	/**
	 * <p> This method used to modify subcategory's name. </p>
	 * @param oldName It holds subcategory oldName.
	 * @param newName It holds subcategory newName.
	 * @param modifiedBy It holds id of who modify subcategory record.
	 * @return boolean If Boolean value is true , record added successfully.
	 *           		Otherwise record not added. 
	 * @throws ApplicationException
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
	 * <p> This method used to remove subcategory. </p> 
	 * @param name It holds subcategory's name.
	 * @return boolean If Boolean value is true , record added successfully.
	 *           		Otherwise record not added.
	 * @throws ApplicationException
	 */
	public boolean removeSubcategoryByName(String name) throws ApplicationException {
		Subcategory subcategory = subcategoryDao.searchSubcategoryByName(name);
		return subcategoryDao.deleteSubcategory(subcategory);
	}

}