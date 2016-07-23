/**
 * 
 */
package service;

import java.sql.Time;
import java.util.List;

import model.User;
/**
 * @author Kumar Albert
 *
 * version 1.0
 * 
 */
public class UserService {
	
	public boolean addUser(String firstName, String lastName, String email, long mobileNumber,
			String password, String address,int createdBy, Time createdAt, 
			int modifiedBy, Time modifiedAt ) {
		User user = new User(firstName, lastName, email, mobileNumber, password, 
				address, createdBy, createdAt, modifiedBy, modifiedAt);
		return userDao.insertUser(user);
		
	}
	
	public List<User> getUserDetails() {
		return userDao.reteriveUserDetails() ;
	}
	
	public User findUserByEmail(String email) {
		return userDao.searchUserByEmail(email);
	}
	
    public boolean modifyUserNameByEmail(String email, String firstName, String lastName) {
        User user = userDao.searchUserByEmail(email);
        user.setFirstName( firstName );
        user.setLastName( lastName );
        return userDao.updateEmployee(user);
    }
    
    public boolean modifyUserEmailByEmail(String oldEmail, String newEmail) {
        User user = userDao.searchUserByEmail(oldEmail);
        user.setEmail( newEmail );
        return userDao.updateEmployee(user);
    }
    
    public boolean modifyUserMobileNumberByEmail(String email, long mobileNumber) {
        User user = userDao.searchUserByEmail(email);
        user.setMobileNumber(mobileNumber);
        return userDao.updateEmployee(user);
    }
    
    public boolean modifyUserPasswordByEmail(String email, String password) {
        User user = userDao.searchUserByEmail(email);
        user.setPassword(password);
        return userDao.updateEmployee(user);
    }
    
    public boolean modifyUserAddressByEmail(String email, String address) {
        User user = userDao.searchUserByEmail(email);
        user.setAddress(address);
        return userDao.updateEmployee(user);
    }
    
    public boolean removeUser(String email) {
        User user = userDao.searchUserByEmail(email);
        return userDao.deleteUserByEmail(user);
    }
	

}
