/**
 * 
 */
package com.i2i.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

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
	private Timestamp createdAt;
	private int modifiedBy;
	private Timestamp modifiedAt;
	private Set<Subcategory> subcategories = new HashSet<Subcategory>();
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
	public Category(String name, int createdBy, Timestamp createdAt, int modifiedBy, Timestamp modifiedAt) {
		this.name = name;
		this.createdBy = createdBy;
		this.createdAt = createdAt;
		this.modifiedBy = modifiedBy;
		this.modifiedAt= modifiedAt;

	}
	
	/**
	 * @param name
	 * @param createdBy
	 * @param createdAt
	 * @param modifiedBy
	 * @param modifiedAt
	 * @param subcategories
	 */
	public Category(String name, int createdBy, Timestamp createdAt, int modifiedBy, Timestamp modifiedAt,
			Set<Subcategory> subcategories) {
		this.name = name;
		this.createdBy = createdBy;
		this.createdAt = createdAt;
		this.modifiedBy = modifiedBy;
		this.modifiedAt = modifiedAt;
		this.subcategories = subcategories;
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

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public int getModifiedBy() {
		return modifiedBy;
	}


	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}


	public Timestamp getModifiedAt() {
		return modifiedAt;
	}


	public void setModifiedAt(Timestamp modifiedAt) {
		this.modifiedAt = modifiedAt;
	}


	public Set<Subcategory> getSubcategories() {
		return subcategories;
	}
	public void setSubcategories(Set<Subcategory> subcategories) {
		this.subcategories = subcategories;
	}
	

}
