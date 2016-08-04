/**
 * 
 */
package com.i2i.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import com.i2i.model.Category;

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
	private Timestamp createdAt;
	private int modifiedBy;
	private Timestamp modifiedAt;
	private Set<Product> products = new HashSet<Product>();
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
	public Subcategory(String name, Category category, int createdBy, Timestamp createdAt, int modifiedBy, Timestamp modifiedAt) {
		this.name = name;
		this.category = category;
		this.createdBy = createdBy;
		this.createdAt = createdAt;
		this.modifiedBy = modifiedBy;
		this.modifiedAt = modifiedAt;
	}


	/**
	 * @param name
	 * @param category
	 * @param createdBy
	 * @param createdAt
	 * @param modifiedBy
	 * @param modifiedAt
	 * @param products
	 */
	public Subcategory(String name, Category category, int createdBy, Timestamp createdAt, int modifiedBy, Timestamp modifiedAt,
			Set<Product> products) {
		this.name = name;
		this.category = category;
		this.createdBy = createdBy;
		this.createdAt = createdAt;
		this.modifiedBy = modifiedBy;
		this.modifiedAt = modifiedAt;
		this.products = products;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}


	public Set<Product> getProducts() {
		return products;
	}


	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}
