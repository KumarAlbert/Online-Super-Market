/**
 * 
 */
package model;

import java.sql.Time;

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
	private int categoryId;
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
	 * @param categoryId
	 * @param createdBy
	 * @param createdAt
	 * @param updatedBy
	 * @param updatedAt
	 */
	public Subcategory(String name, int categoryId, int createdBy, Time createdAt, int modifiedBy, Time modifiedAt) {
		this.name = name;
		this.categoryId = categoryId;
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

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
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

}
