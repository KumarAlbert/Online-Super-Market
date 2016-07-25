/**
 * 
 */
package model;
import model.User;
import java.sql.Time;

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
    private Time createdAt;
    private Time modifiedAt;
    private int createdBy;
    private int modifiedBy;
    
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
	public PurchaseOrder( double total, String paymentType, boolean status, Time createdAt, Time modifiedAt,
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
	public PurchaseOrder(User user, double total, String paymentType, boolean status, Time createdAt, Time modifiedAt,
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

	public Time getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Time createdAt) {
		this.createdAt = createdAt;
	}

	public Time getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Time modifiedAt) {
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
}
