/**
 * 
 */
package service;

import java.sql.Time;
import java.util.List;
import model.Category;
import dao.CategoryDao;
import exception.ApplicationException;


/**
 * @author Kumar Albert
 *
 * version 1.0
 * 
 */
public class CategoryService {
	
	CategoryDao categoryDao = new CategoryDao();

	public boolean addCategory(String name, int createdBy, Time createdAt,
			int modifiedBy, Time modifiedAt ) throws ApplicationException{
		Category category = new Category(name, createdBy, createdAt, modifiedBy, modifiedAt);
		return categoryDao.insertCategory(category);
	}
	
	public List<Category> getCategoryDetails() {
		return categoryDao.reteriveCategoryDetails();		
	}
	
	public Category findCategoryByName(String name) {
		return categoryDao.searchCategoryByName(name);
	}
	
	public boolean modifyCategoryNameByName(String oldName,String newName, int modifiedBy, Time modifiedAt) {
		Category category = categoryDao.searchCategoryByName(oldName);
		category.setName(newName);
		category.setModifiedBy(modifiedBy);
		category.setModifiedAt(modifiedAt);
		return categoryDao.updateCategory(category);
	}
	
	public boolean removeCategoryByName(String name) {
		Category category = categoryDao.searchCategoryByName(name);
		return categoryDao.deleteCategory(category);
	}
}
