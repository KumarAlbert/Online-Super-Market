/**
 * 
 */
package service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Time;

import java.util.List;
import dao.UserDao;
import exception.ApplicationException;
import model.User;
/**
 * @author Kumar Albert
 *
 * version 1.0
 * 
 */
@Service ("userService")
public class UserService {
	
	@Autowired UserDao userDao;
	
	public boolean addUser(User user) throws ApplicationException {
		return userDao.insertUser(user);
	}
	
	public List<User> getUserDetails()throws ApplicationException {
		return userDao.retrieveUserDetails() ;
	}
	
	public User findUserByEmail(String email) throws ApplicationException  {
		return userDao.searchUserByEmail(email);
	}
	
    public boolean modifyUserNameByEmail(String email, String firstName, String lastName, 
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
    }
	

}
