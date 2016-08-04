/**
 * 
 */
package com.i2i.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.i2i.dao.UserDao;
import com.i2i.exception.ApplicationException;
import com.i2i.model.User;
/**
 * @author Kumar Albert
 *
 * version 1.0static
 * 
 */
@Service
public class UserService {
	
	@Autowired
	private	UserDao userDao;
	
	public boolean addUser(User user) throws ApplicationException {
		return userDao.insertUser(user);
	}
	
	public List<User> getUserDetails()throws ApplicationException {

		return userDao.retrieveUserDetails() ;
	}
	
	public User findUser(User user) throws ApplicationException  {
        System.out.println("service inside");
        System.out.println(userDao);
		return userDao.searchUser(user);
	}
	
/*    public boolean modifyUserNameByEmail(String email, String firstName, String lastName, 
    		int modifiedBy, Time modifiedAt) throws ApplicationException  {
        User user = userDao.searchUserByEmail(email);
        user.setFirstName( firstName );
        user.setLastName( lastName );
        user.setModifiedBy(modifiedBy);
        user.setModifiedAt(modifiedAt);
        return userDao.updateUser(user);
    }
    
    public boolean modifyUserEmailByEmail(String oldEmail, String newEmail, 
    		int modifiedBy, Time modifiedAt) throws ApplicationException  {
        User user = userDao.searchUserByEmail(oldEmail);
        user.setEmail( newEmail );
        user.setModifiedBy(modifiedBy);
        user.setModifiedAt(modifiedAt);
        return userDao.updateUser(user);
    }
    
    public boolean modifyUserMobileNumberByEmail(String email, long mobileNumber, 
    		int modifiedBy, Time modifiedAt) throws ApplicationException  {
        User user = userDao.searchUserByEmail(email);
        user.setMobileNumber(mobileNumber);
        user.setModifiedBy(modifiedBy);
        user.setModifiedAt(modifiedAt);
        return userDao.updateUser(user);
    }
    
    public boolean modifyUserPasswordByEmail(String email, String password, 
    		int modifiedBy, Time modifiedAt) throws ApplicationException {
        User user = userDao.searchUserByEmail(email);
        user.setPassword(password);
        user.setModifiedBy(modifiedBy);
        user.setModifiedAt(modifiedAt);
        return userDao.updateUser(user);
    }
    
    public boolean modifyUserAddressByEmail(String email, String address, 
    		int modifiedBy, Time modifiedAt) throws ApplicationException {
        User user = userDao.searchUserByEmail(email);
        user.setAddress(address);
        user.setModifiedBy(modifiedBy);
        user.setModifiedAt(modifiedAt);
        return userDao.updateUser(user);
    }
    
    public boolean removeUser(String email) throws ApplicationException  {
        User user = userDao.searchUserByEmail(email);
        return userDao.deleteUser(user);
    }*/
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


}
