/**
 * 
 */
package com.i2i.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.i2i.exception.ApplicationException;
import com.i2i.model.Cart;

/**
 * @author Kumar Albert
 *
 * version 1.0
 * 
 */
@Repository("cartDao")
public class CartDao extends GenericDao{
	
    public boolean insertCart(Cart cart) throws ApplicationException {
        Transaction transaction = null;
        try {
        	openSession();
            System.out.println(cart);
            transaction = session.beginTransaction();
            System.out.println(cart);
            System.out.println(transaction);
            session.save(cart);
            transaction.commit();
            return true;
        } catch (HibernateException e) {
        	e.printStackTrace();
            throw new ApplicationException("Some error occured while inserting details of Cart: "
                                            +cart.getId(),e);
        } finally {
            closeSession(session); 
        }
    }
    
    public List<Cart> retrieveCartDetails() throws ApplicationException {
        try {
        	openSession();
        	System.out.println(session);
            return session.createQuery("FROM Cart").list(); 
        } catch (HibernateException e) {
            throw new ApplicationException("Some error occured while listing the details of all cart",e); 
        } finally {
            closeSession(session);  
        }
    }
    
    public Cart searchCartByOrderId(int orderId) throws ApplicationException {

    	try {
    		openSession();
            return (Cart)session.get(Cart.class, orderId);
        } catch (HibernateException e) {
            throw new ApplicationException("Some error occured while viewing details of cart",e); 
        } finally {
            closeSession(session); 
        }  
    }

    public Cart searchCartById(int id) throws ApplicationException {
    	Transaction transaction = null;
    	try {
    	  	openSession();
    	  	System.out.println(session);
    	  	System.out.println("inside Cart dao");
    	   	transaction = session.beginTransaction();
	      	String sql = "SELECT * FROM Cart WHERE id = :id";
	      	SQLQuery query = session.createSQLQuery(sql);
	      	query.addEntity(Cart.class);
	      	query.setParameter("id", id);
	      	Object object = query.list().get(0);
	      	Cart cartFromDao = (Cart)object;
	      	System.out.println(cartFromDao);
	      	transaction.commit();
	      	return cartFromDao;
    	} catch (HibernateException e) {
    		e.printStackTrace();
    		throw new ApplicationException("Some error occured while viewing details of "
    				+id,e); 
    	} finally {
    		closeSession(session); 
    	}  
    }
    
    public boolean updateCart(Cart cart) throws ApplicationException {
        Transaction transaction = null;
        try {
        	openSession();
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
        Transaction transaction = null;
        try {
        	openSession();
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