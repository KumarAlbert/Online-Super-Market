/**
 * 
 */
package com.i2i.model;

import java.sql.Timestamp;
import com.i2i.model.Product;
/**
 * <p> Cart model object.
 * <p>Contains various attributes of model and its getters and setters. 
 * @author Mukilan.K
 *
 * @version 1.0

 */
public class Cart {
	

	private int id;
    private PurchaseOrder purchaseOrder;
    private Product product;
    private int quantity;
    private double totalPrice;
    private Timestamp createdAt;
    private Timestamp modifiedAt;
    private int createdBy;
    private int modifiedBy;

	/**
	 * 
	 */
	public Cart() {
	}

	/**
	 * @param purchaseOrder
	 * @param product
	 * @param quantity
	 * @param totalPrice
	 * @param createdAt
	 * @param modifiedAt
	 * @param createdBy
	 * @param modifiedBy
	 */
	public Cart(PurchaseOrder purchaseOrder, Product product, int quantity, double totalPrice, java.sql.Timestamp createdAt,
			Timestamp modifiedAt, int createdBy, int modifiedBy) {
		this.purchaseOrder= purchaseOrder;
		this.product = product;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Timestamp modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public int getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	@Override
	public String toString() {
		return "Cart [id=" + id + ", purchaseOrder=" + purchaseOrder + ", product=" + product + ", quantity=" + quantity
				+ ", totalPrice=" + totalPrice + ", createdAt=" + createdAt + ", modifiedAt=" + modifiedAt
				+ ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy + "]";
	}
}
