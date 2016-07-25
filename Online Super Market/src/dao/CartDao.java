/**
 * 
 */
package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import exception.ApplicationException;
import model.Cart;

/**
 * @author Kumar Albert
 *
 * version 1.0
 * 
 */
public class CartDao extends GenericDao{
	
    public boolean insertCart(Cart cart) throws ApplicationException {
        Session session = createSession();  
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(cart);
            transaction.commit();
            return true;
        } catch (HibernateException e) {
            throw new ApplicationException("Some error occured while inserting details of Cart: "
                                            +cart.getId(),e);
        } finally {
            closeSession(session); 
        }
    }
    
    public List<Cart> retrieveCartDetails() throws ApplicationException {
        Session session = createSession(); 
        try {
            return session.createQuery("FROM Cart").list(); 
        } catch (HibernateException e) {
            throw new ApplicationException("Some error occured while listing the details of all cart",e); 
        } finally {
            closeSession(session);  
        }
    }
    
    public Cart searchCartByOrderId(int orderId) throws ApplicationException {
        Session session = createSession();  
        try {
            return (Cart)session.get(Cart.class, orderId);
        } catch (HibernateException e) {
            throw new ApplicationException("Some error occured while viewing details of cart",e); 
        } finally {
            closeSession(session); 
        }  
    }
    
    public boolean updateCart(Cart cart) throws ApplicationException {
        Session session = createSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(cart); 
            transaction.commit();
            return true;
        } catch (HibernateException e) {
            throw new ApplicationException("Some error occured while updating details of "+ 
            		                        cart.getId(),e); 
        } finally {
            closeSession(session); 
        }
    }
    
    public boolean deleteCart(Cart cart) throws ApplicationException {
        Session session = createSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(cart); 
            transaction.commit();
            return true;
        } catch (HibernateException e) {
            throw new ApplicationException("Some error occured while deleting the details of "+
            		                        cart.getId(),e); 
        } finally {
            closeSession(session); 
        }	
    }
}
