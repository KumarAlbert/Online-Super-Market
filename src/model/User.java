/**
 * 
 */
package model;

import java.sql.Time;

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
	private long mobileNumber;
	private String password;
	private String address;
	private int createdBy;
	private Time createdAt;
	private int modifiedBy;
	private Time modifiedAt;

	
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
	public User(String firstName, String lastName, String email, long mobileNumber, String password, String address,
			int createdBy, Time createdAt, int modifiedBy, Time modifiedAt) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.address = address;
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

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
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
