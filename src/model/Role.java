/**
 * 
 */
package model;

import java.sql.Time;

/**
 * <p>Role model object>
 * <p>Contains various attributes of model and its getters and setters. 
 * @author Mukilan.K
 *
 * @version 1.0

 */
public class Role {
	
    private int id;
    private String name;
    private Time createdAt;
    private Time modifiedAt;
    private int createdBy;
    private int modifiedBy;

	/**
	 * 
	 */
	public Role() {
	}

	/**
	 * @param name
	 * @param createdAt
	 * @param modifiedAt
	 * @param createdBy
	 * @param modifiedBy
	 */
	public Role(String name, Time createdAt, Time modifiedAt, int createdBy, int modifiedBy) {
		this.name = name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
}
