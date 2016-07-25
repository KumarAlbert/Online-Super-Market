/**
 * 
 */
package model;

import java.sql.Time;

/**
 * @author Kumar Albert
 *
 * version 1.0
 * <p> The Project class acts as a model which represents Project details</p>
 * 
 */
public class Product {
	private int id;
	private String name;
	private String description;
	private int subcategoryId;
	private String imageUrl;
	private int stock;
	private double price;
	private int createdBy;
	private Time createdAt;
	private int modifiedBy;
	private Time modifiedAt;

	/**
	 * 
	 */
	public Product() {
	}

	/**
	 * @param name
	 * @param description
	 * @param subcategoryId
	 * @param imageUrl
	 * @param stock
	 * @param price
	 * @param createdBy
	 * @param createdAt
	 * @param updatedBy
	 * @param updatedAt
	 */
	public Product(String name, String description, int subcategoryId, String imageUrl, int stock,double price,
			int createdBy, Time createdAt, int modifiedBy, Time modifiedAt) {
		this.name = name;
		this.description = description;
		this.subcategoryId = subcategoryId;
		this.imageUrl = imageUrl;
		this.stock = stock;
		this.price = price;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getSubcategoryId() {
		return subcategoryId;
	}

	public void setSubcategoryId(int subcategoryId) {
		this.subcategoryId = subcategoryId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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
