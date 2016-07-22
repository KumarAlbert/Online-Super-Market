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
	private int updatedBy;
	private Time updatedAt;
	

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

	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Time getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Time updatedAt) {
		this.updatedAt = updatedAt;
	}

}
