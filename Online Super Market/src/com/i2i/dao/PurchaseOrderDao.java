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
 * @author Kumar Albert
 *
 * version 1.0
 * 
 */
@Repository("purchaseOrderDao")
public class PurchaseOrderDao extends GenericDao {
	
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
