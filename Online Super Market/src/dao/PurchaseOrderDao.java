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
import model.PurchaseOrder;

/**
 * @author Kumar Albert
 *
 * version 1.0
 * 
 */
public class PurchaseOrderDao extends GenericDao {
	
	   public boolean insertPurchaseOrder(PurchaseOrder purchaseOrder) throws ApplicationException {
	        Session session = createSession();  
	        Transaction transaction = null;
	        try {
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
	        Session session = createSession(); 
	        try {
	            return session.createQuery("FROM PurchaseOrder").list(); 
	        } catch (HibernateException e) {
	            throw new ApplicationException("Some error occured while listing the details of all cart",e); 
	        } finally {
	            closeSession(session);  
	        }
	    }

}
