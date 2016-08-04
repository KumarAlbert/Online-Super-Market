/**
 * 
 */
package com.i2i.dao;

import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.i2i.model.User;


import com.i2i.exception.ApplicationException;
/**
 * @author Mukilan.K
 *
 * @version 1.0
 */
@Repository("userDao")
public class UserDao extends GenericDao{

    public boolean insertUser(User user) throws ApplicationException {
        Transaction transaction = null;
        try {
        	openSession();
            transaction = session.beginTransaction();
            System.out.println(transaction);
            session.save(user);
            transaction.commit();
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new ApplicationException("Some error occured while inserting details of user: "
                                            +user.getFirstName());
        } finally {
        	closeSession(session);
        }
    }
    
    public List<User> retrieveUserDetails() throws ApplicationException {
        Transaction transaction = null;
        try {
        	openSession();
            transaction = session.beginTransaction();
            System.out.println(session);
            System.out.println(transaction);
            List<User> users = session.createQuery("FROM User").list();
            transaction.commit();
            return users;
        } catch (HibernateException e) {
            throw new ApplicationException("Some error occured while listing the details of all Users",e); 
        } finally {
        	closeSession(session);
        }
    }
    
    public User searchUser(User user) throws ApplicationException {
        Transaction transaction = null;
        try { 
        	openSession();
        	transaction = session.beginTransaction();
            String sql = "SELECT * FROM User WHERE email = :email and password= :password";
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(User.class);
            query.setParameter("email", user.getEmail());
            query.setParameter("password", user.getPassword());
            Object object = query.list().get(0);
            User userFromDao = (User)object;
            transaction.commit();
            return userFromDao;
        } catch (HibernateException e) {
            throw new ApplicationException("Some error occured while viewing details of "
                                            +user.getEmail(),e); 
        } catch (IndexOutOfBoundsException e) {
            throw new ApplicationException("Some error occured while viewing details of "
                    +user.getEmail(),e); 
           } finally {
        	   closeSession(session);
        }  
    }
    
  /*  public boolean updateUser(User user) throws ApplicationException {
        Session session = createSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(user); 
            transaction.commit();
            return true;
        } catch (HibernateException e) {
            throw new ApplicationException("Some error occured while updating details of "+ 
                                           user.getFirstName(),e); 
        } finally {
            closeSession(session); 
        }org.hibernate.transaction.JDBCTransaction@456c0603

    }
    
    public boolean deleteUser(User user) throws ApplicationException {
        Session session = createSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(user); 
            transaction.commit();
            return true;
        } catch (HibernateException e) {
            throw new ApplicationException("Some error occured while deleting the details of "+
                                            user.getFirstName(),e); 
        } finally {
            closeSession(session); 
        }	
    }*/
}
