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
 * <h1> User Service</h1>
 * <p> It provides user related services.</p>
 * @author Kumar Albert
 *
 * version 1.0static
 * 
 */
@Service
public class UserService {
	
	@Autowired
	private	UserDao userDao;
	
	
	/**
	 * <p> This method used to add user.</p>
	 * @param user It holds user object.
	 * @return boolean This returns true, if operation successfully done.
	 * 					Otherwise it returns false.
	 * @throws ApplicationException
	 */
	public boolean addUser(User user) throws ApplicationException {
		return userDao.insertUser(user);
	}
	
	/**
	 * <p> THis method used to get user details </p>
	 * @return List .It returns user list.
	 * @throws ApplicationException
	 */
	public List<User> getUserDetails()throws ApplicationException {

		return userDao.retrieveUserDetails() ;
	}
	
	/**
	 * @param user
	 * @return
	 * @throws ApplicationException
	 */
	public User findUser(User user) throws ApplicationException  {
        System.out.println("service inside");
        System.out.println(userDao);
		return userDao.searchUser(user);
	}
}
