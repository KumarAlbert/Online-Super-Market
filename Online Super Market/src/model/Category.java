/**
 * 
 */
package model;

import java.sql.Time;

/**
 * @author Kumar Albert
 *
 * version 1.0
 * <p> The Category class acts as a model which represents Category details</p>
 * 
 */
public class Category {
	private int id;
	private String name;
	private int createdBy;
	private Time createdAt;
	private int modifiedBy;
	private Time modifiedAt;
	
	/**
	 * 
	 */
	public Category() {
	}
	

	/**
	 * @param name
	 * @param createdBy
	 * @param createdAt
	 * @param modifiedBy
	 * @param modifiedAt
	 */
	public Category(String name, int createdBy, Time createdAt, int modifiedBy, Time modifiedAt) {
		this.name = name;
		this.createdBy = createdBy;
		this.createdAt = createdAt;
		this.modifiedBy = modifiedBy;
		this.modifiedAt= modifiedAt;

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
	

}
