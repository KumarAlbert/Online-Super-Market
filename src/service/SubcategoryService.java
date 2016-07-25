/**
 * 
 */
package service;

import java.sql.Time;
import java.util.List;

import model.Category;
import model.Subcategory;
/**
 * @author Kumar Albert
 *
 * version 1.0
 * 
 */
public class SubcategoryService {
	
	SubcategoryDao subcategoryDao = new SubcategoryDao();
	public boolean addSubcategory(String name, int createdBy, Time createdAt,
			int modifiedBy, Time modifiedAt) {
		Subcategory subcategory = new Subcategory(name, categoryId, createdBy,
				createdAt, updatedBy, updatedAt);
		return subcategoryDao.insertSubcategory(subcategory);
	}
	
	public List<Subcategory> getSubcategoryDetails() {
		return subcategoryDao.reteriveSubcategoeryDetails();		
	}
	
	public Subcategory findSubcategoryByName(String name) {
		return sucategoryDao.searchSubcategoryByName(name);
	}
	
	public boolean modifySubcategoryNameByName(String oldName, String newName, int modifiedBy, Time modifiedAt) {
		Subcategory subcategory = subcategoryDao.searchSubcategoryByName(oldName);
		subcategory.setName(newName);
		subcategory.setModifiedBy(modifiedBy);
		subcategory.setModifiedAt(modifiedAt);
		return categoryDao.updateCategory(subcategory);
	}
	
	public boolean removeCategoryByName(String name) {
		Subcategory subcategory = subcategoryDao.searchSubcategoryByName(name);
		return subcategoryDao.deleteSubcategory(subcategory);
	}

}
