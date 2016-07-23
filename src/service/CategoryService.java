/**
 * 
 */
package service;

import java.sql.Time;
import java.util.List;

import model.Category;
/**
 * @author Kumar Albert
 *
 * version 1.0
 * 
 */
public class CategoryService {
	public boolean addCategory(String name, int createdBy, Time createdAt,
			int modifiedBy, Time modifiedAt ) {
		Category category = new Category(name, createdBy, createdAt, modifiedBy, modifiedAt);
		return categoryDao.insertCategory(category);
	}
	
	public List<Category> getCategoryDetails() {
		return categoryDao.reteriveCategoryDetails();		
	}
	
	public Category findCategoryByName(String name) {
		return categoryDao.searchCategoryByName(name);
	}
	
	public boolean modifyCategoryNameByName(String oldName,String newName) {
		Category category = categoryDao.searchCategoryByName(oldName);
		category.setName(newName);
		return categoryDao.updateCategory(category);
	}
	
	public boolean removeCategoryByName(String name) {
		Category category = categoryDao.searchCategoryByName(name);
		return categoryDao.deleteCategory(category);
	}
}
