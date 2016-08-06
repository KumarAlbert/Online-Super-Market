/**
 * 
 */
package com.i2i.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.i2i.exception.ApplicationException;
import com.i2i.model.PurchaseOrder;

/**
 * <h1>PurchaseOrderDao</h1>
 * <p>Performs all purchaseorder related database tasks using hibernate.<p>
 * @author Kumar Albert
 *
 * version 1.0
 * 
 */
@Repository("purchaseOrderDao")
public class PurchaseOrderDao extends GenericDao {
	
	/**
	 * Inserts product details into database.
	 * @param product
	 *     product object that has to be inserted into database.
     * @return True
     *     If product object is inserted.	
     * @throws ApplicationException
	 *     If there is any interruption occurred in the database.
	 */
    public boolean insertPurchaseOrder(PurchaseOrder purchaseOrder) throws ApplicationException {
	    Transaction transaction = null;
	    try {
	       	openSession();
	        transaction = session.beginTransaction();
	        session.save(purchaseOrder);
	        transaction.commit();
	        return true;
	    } catch (HibernateException e) {
	        throw new ApplicationException("Some error occured while inserting details of Cart: "
	                                        +purchaseOrder.getId(),e);
	    } finally {
	         closeSession(session); 
	    }
	}
	    
    /**
     * Retrieves the purchaseorder list present in the database.
     * @return List<PurchaseOrder>
     *     List of purchaseorder objects to be returned.
     * @throws ApplicationException
     *     If there is any interruption occurred in the database.
     */ 
    public List<PurchaseOrder> retrievePurchaseOrderDetails() throws ApplicationException {
	    try {
	       	openSession();
	        return session.createQuery("FROM PurchaseOrder").list(); 
	    } catch (HibernateException e) {
	        throw new ApplicationException("Some error occured while listing the details of all cart",e); 
	     } finally {
	         closeSession(session);  
	    }
    }

}
