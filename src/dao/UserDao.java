/**
 * 
 */
package dao;

import java.util.List;

import org.hibernate.HibernateException; 
import org.hibernate.Transaction;
import org.hibernate.Session; 


import model.User;
import exception.ApplicationException;
/**
 * @author Mukilan.K
 *
 * @version 1.0
 */
public class UserDao extends GenericDao{
    public boolean insertUser(User user) throws ApplicationException {
        Session session = createSession();  
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            return true;
        } catch (HibernateException e) {
            throw new ApplicationException("Some error occured while inserting details of user: "
                                            +user.getFirstName(),e);
        } finally {
            closeSession(session); 
        }
    }
    
    public List<User> viewAllUsers() throws ApplicationException {
        Session session = createSession(); 
        try {
            return session.createQuery("FROM User").list(); 
        } catch (HibernateException e) {
            throw new ApplicationException("Some error occured while listing the details of all Users",e); 
        } finally {
            closeSession(session);  
        }
    }
    
    public User viewAUser(String email) throws ApplicationException {
        Session session = createSession();  
        try {
            return (User)session.get(User.class, email);
        } catch (HibernateException e) {
            throw new ApplicationException("Some error occured while viewing details of "
                                            +email,e); 
        } finally {
            closeSession(session); 
        }  
    }
    
    public boolean updateUserDetails(User user) throws ApplicationException {
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
        }
    }
    
    public boolean deleteAUser(User user) throws ApplicationException {
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
    }
}
