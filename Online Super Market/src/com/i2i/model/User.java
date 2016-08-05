/**
 * 
 */
package com.i2i.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import com.i2i.model.PurchaseOrder;
/**
 * @author Kumar Albert
 *
 * version 1.0
 * <p> The User class acts as a model which represents User details</p>
 */
public class User {



	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String mobileNumber;
	private String password;
	private String address;
	private Timestamp createdAt;
	private int modifiedBy;
	private Timestamp modifiedAt;
    private Set<PurchaseOrder> purchaseOrders = new HashSet<PurchaseOrder>();
    private Set<Role> roles = new HashSet<Role>();	
	/**
	 * 
	 */
	public User() {
	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param mobileNumber
	 * @param password
	 * @param address
	 * @param createdBy
	 * @param createdAt
	 * @param modifiedBy
	 * @param modifiedAt
	 */
	public User(String firstName, String lastName, String email, String mobileNumber, String password, String address,
			int createdBy, Timestamp createdAt, int modifiedBy, Timestamp modifiedAt) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.address = address;
		this.createdAt = createdAt;
		this.modifiedBy = modifiedBy;
		this.modifiedAt = modifiedAt;
	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param mobileNumber
	 * @param password
	 * @param address
	 * @param createdBy
	 * @param createdAt
	 * @param modifiedBy
	 * @param modifiedAt
	 * @param purchaseOrders
	 */
	public User(String firstName, String lastName, String email, String mobileNumber, String password, String address,
			int createdBy, Timestamp createdAt, int modifiedBy, Timestamp modifiedAt, Set<PurchaseOrder> purchaseOrders) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.address = address;
		this.createdAt = createdAt;
		this.modifiedBy = modifiedBy;
		this.modifiedAt = modifiedAt;
		this.purchaseOrders = purchaseOrders;
	}
	
	/**
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param mobileNumber
	 * @param password
	 * @param address
	 * @param createdBy
	 * @param createdAt
	 * @param modifiedBy
	 * @param modifiedAt
	 * @param purchaseOrders
	 * @param roles
	 */
	public User(String firstName, String lastName, String email, String mobileNumber, String password, String address,
			int createdBy, Timestamp createdAt, int modifiedBy, Timestamp modifiedAt, Set<PurchaseOrder> purchaseOrders,
			Set<Role> roles) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.address = address;
		this.createdAt = createdAt;
		this.modifiedBy = modifiedBy;
		this.modifiedAt = modifiedAt;
		this.purchaseOrders = purchaseOrders;
		this.roles = roles;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public Set<PurchaseOrder> getPurchaseOrders() {
		return purchaseOrders;
	}

	public void setPurchaseOrders(Set<PurchaseOrder> purchaseOrders) {
		this.purchaseOrders = purchaseOrders;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", mobileNumber=" + mobileNumber + ", password=" + password + ", address=" + address + ", createdAt="
				+ createdAt + ", modifiedBy=" + modifiedBy + ", modifiedAt=" + modifiedAt + ", purchaseOrders="
				+ purchaseOrders + ", roles=" + roles + "]";
	}

}
