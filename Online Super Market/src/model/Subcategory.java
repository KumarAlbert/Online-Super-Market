/**
 * 
 */
package model;

import java.sql.Time;
import model.Category;

/**
 * @author Kumar Albert
 *
 * version 1.0
 * <p> The Subcategory class acts as a model which represents Subategory details</p>
 *
 */
public class Subcategory {
	private int id;
	private String name;
	private Category category;
	private int createdBy;
	private Time createdAt;
	private int modifiedBy;
	private Time modifiedAt;
	
	/**
	 * 
	 */
	public Subcategory() {
	}

	
	/**
	 * @param name
	 * @param category
	 * @param createdBy
	 * @param createdAt
	 * @param modifiedBy
	 * @param modifiedAt
	 */
	public Subcategory(String name, Category category, int createdBy, Time createdAt, int modifiedBy, Time modifiedAt) {
		this.name = name;
		this.category = category;
		this.createdBy = createdBy;
		this.createdAt = createdAt;
		this.modifiedBy = modifiedBy;
		this.modifiedAt = modifiedAt;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Time getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Time createdAt) {
		this.createdAt = createdAt;
	}

	public int getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Time getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Time modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
