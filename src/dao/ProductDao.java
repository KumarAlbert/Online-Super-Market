/**
 * 
 */
package dao;

import java.util.List;

import org.hibernate.HibernateException; 
import org.hibernate.Transaction;
import org.hibernate.Session;

import model.Product;
import exception.ApplicationException;
/**
 * @author Mukilan.K
 *
 * @version 1.0
 */
public class ProductDao extends GenericDao {

    public boolean insertProduct(Product product) throws ApplicationException {
        Session session = createSession();  
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
            return true;
        } catch (HibernateException e) {
            throw new ApplicationException("Some error occured while inserting details of product: "
                                            +product.getName(),e);
        } finally {
            closeSession(session); 
        }
    }
    
    public List<Product> viewAllProducts() throws ApplicationException {
        Session session = createSession(); 
        try {
            return session.createQuery("FROM Product").list(); 
        } catch (HibernateException e) {
            throw new ApplicationException("Some error occured while listing the details of all Products",e); 
        } finally {
            closeSession(session);  
        }
    }
    
    public Product viewAProduct(int id) throws ApplicationException {
        Session session = createSession();  
        try {
            return (Product)session.get(Product.class, id);
        } catch (HibernateException e) {
            throw new ApplicationException("Some error occured while viewing details of "
                                            +id,e); 
        } finally {
            closeSession(session); 
        }  
    }
    
    public boolean updateProductDetails(Product product) throws ApplicationException {
        Session session = createSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(product); 
            transaction.commit();
            return true;
        } catch (HibernateException e) {
            throw new ApplicationException("Some error occured while updating details of "+ 
            		                        product.getId(),e); 
        } finally {
            closeSession(session); 
        }
    }
    
    public boolean deleteAProduct(Product product) throws ApplicationException {
        Session session = createSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(product); 
            transaction.commit();
            return true;
        } catch (HibernateException e) {
            throw new ApplicationException("Some error occured while deleting the details of "+
            		                        product.getId(),e); 
        } finally {
            closeSession(session); 
        }	
    }

}
