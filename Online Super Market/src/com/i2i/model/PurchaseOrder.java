/**
 * 
 */
package com.i2i.model;
import com.i2i.model.User;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>Order model object</p>
 * <p>Contains various attributes of model and its getters and setters. 
 * @author Mukilan.K
 *
 * @version 1.0
 */
public class PurchaseOrder {
	
    private int id;
    private User user;
    private double total;
    private String paymentType;
    private boolean status;
    private Timestamp createdAt;
    private Timestamp modifiedAt;
    private int createdBy;
    private int modifiedBy;
    private Set<Cart> carts = new HashSet<Cart>();
	/**
	 * 
	 */
	public PurchaseOrder() {
	}
	

	/**
	 * @param userId
	 * @param total
	 * @param paymentType
	 * @param status
	 * @param createdAt
	 * @param modifiedAt
	 * @param createdBy
	 * @param modifiedBy
	 */
	public PurchaseOrder( double total, String paymentType, boolean status, Timestamp createdAt, Timestamp modifiedAt,
			int createdBy, int modifiedBy) {
		this.total = total;
		this.paymentType = paymentType;
		this.status = status;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
	}


	/**
     * @param user
	 * @param total
	 * @param paymentType
	 * @param status
	 * @param createdAt
	 * @param modifiedAt
	 * @param createdBy
	 * @param modifiedBy
	 */
	public PurchaseOrder(User user, double total, String paymentType, boolean status, Timestamp createdAt, Timestamp modifiedAt,
			int createdBy, int modifiedBy) {
		this.user = user;
		this.total = total;
		this.paymentType = paymentType;
		this.status = status;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
	}


	/**
	 * @param user
	 * @param total
	 * @param paymentType
	 * @param status
	 * @param createdAt
	 * @param modifiedAt
	 * @param createdBy
	 * @param modifiedBy
	 * @param carts
	 */
	public PurchaseOrder(User user, double total, String paymentType, boolean status, Timestamp createdAt, Timestamp modifiedAt,
			int createdBy, int modifiedBy, Set<Cart> carts) {
		this.user = user;
		this.total = total;
		this.paymentType = paymentType;
		this.status = status;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.carts = carts;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
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


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Set<Cart> getCarts() {
		return carts;
	}


	public void setCarts(Set<Cart> carts) {
		this.carts = carts;
	}
}
