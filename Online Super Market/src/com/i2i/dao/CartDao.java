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
 * </h1>CartDao</h1>
 * <p>Performs all cart related database tasks using hibernate.<p>
 * @author Kumar Albert
 *
 * version 1.0
 * 
 */
@Repository("cartDao")
public class CartDao extends GenericDao{
	
	/**
	 * Inserts cart details into the database.
	 * @param cart
	 *     cart object to be inserted.
	 * @return True
	 *     If cart objest is inserted.
	 * @throws ApplicationException
	 *      If there is any interruption occurred in the database.
	 */
    public boolean insertCart(Cart cart) throws ApplicationException {
        Transaction transaction = null;
        try {
        	openSession();
            transaction = session.beginTransaction();
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
    
    /**
     * Retrieves the category list present in the database.
     * @return List<Cart>
     *     List of cart objects to be returned.
     * @throws ApplicationException
     *    If there is any interruption occurred in the database.
     */
    @SuppressWarnings("unchecked")
	public List<Cart> retrieveCartDetails() throws ApplicationException {
        try {
        	openSession();
            return session.createQuery("FROM Cart").list(); 
        } catch (HibernateException e) {
            throw new ApplicationException("Some error occured while listing the details of all cart",e); 
        } finally {
            closeSession(session);  
        }
    }
    
    /**
     * Retrieves cart object for the given orderid.
     * @param orderId
     *     orderid of the cart to be found.
     * @return cart
     *     cart object to be returned.
     * @throws ApplicationException
     *     If there is any interruption occurred in the database.
     */
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

    /**
     * Retrieves cart object for the given id.
     * @param id
     *     id of the cart to be found.
     * @return cart
     *     cart object to be returned.
     * @throws ApplicationException
     *     If there is any interruption occurred in the database.
     */
    public Cart searchCartById(int id) throws ApplicationException {
    	Transaction transaction = null;
    	try {
    	  	openSession();
    	   	transaction = session.beginTransaction();
	      	String sql = "SELECT * FROM Cart WHERE id = :id";
	      	SQLQuery query = session.createSQLQuery(sql);
	      	query.addEntity(Cart.class);
	      	query.setParameter("id", id);
	      	Object object = query.list().get(0);
	      	Cart cartFromDao = (Cart)object;
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
    
    /**
     * Updates the cart object into the database.
     * @param cart
     *     cart object to be updated.
     * @return True
     *     If category object is updated.
     * @throws ApplicationException
     *     If there is any interruption occurred in the database.
     */
    public boolean updateCart(Cart cart) throws ApplicationException {
        Transaction transaction = null;
        try {
        	openSession();
        	System.out.println(cart);
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
    
    /**
     * Deletes entire cart object from the database.
     * @param cart
     *     cart object to be deleted.
     * @return True 
     *     If cart object is deleted.
     * @throws ApplicationException
     *     If there is any interruption occurred in the database.
     */
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
