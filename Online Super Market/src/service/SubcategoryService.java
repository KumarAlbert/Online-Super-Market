/**
 * 
 */
package service;

import java.sql.Time;

import java.util.List;

import model.Subcategory;
import dao.SubcategoryDao;
import exception.ApplicationException;
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
public class SubcategoryService {
	
	SubcategoryDao subcategoryDao = new SubcategoryDao();
	
	/**
	 * @param name
	 * @param createdBy
	 * @param createdAt
	 * @param modifiedBy
	 * @param modifiedAt
	 * @return boolean
	 *             If Boolean value is true , record added successfully. Otherwise record didn't added.
	 */
	public boolean addSubcategory(String name,int categoryId, int createdBy, Time createdAt,
			int modifiedBy, Time modifiedAt) throws ApplicationException {
		Subcategory subcategory = new Subcategory(name, categoryId, createdBy, createdAt, modifiedBy, modifiedAt);
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
	public boolean modifySubcategoryNameByName(String oldName, String newName, 
			int modifiedBy, Time modifiedAt) throws ApplicationException {
		Subcategory subcategory = subcategoryDao.searchSubcategoryByName(oldName);
		subcategory.setName(newName);
		subcategory.setModifiedBy(modifiedBy);
		subcategory.setModifiedAt(modifiedAt);
		return subcategoryDao.updateSubcategory(subcategory);
	}
	
	/**
	 * @param name
	 * @return boolean
	 *             If Boolean value is true , record removed successfully. Otherwise record didn't removed.
	 */
	public boolean removeCategoryByName(String name) throws ApplicationException {
		Subcategory subcategory = subcategoryDao.searchSubcategoryByName(name);
		return subcategoryDao.deleteSubcategory(subcategory);
	}

}
