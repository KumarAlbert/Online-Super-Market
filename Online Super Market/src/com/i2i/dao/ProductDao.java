/**
 * 
 */
package com.i2i.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.i2i.model.Product;
import com.i2i.exception.ApplicationException;
/**
 * <h1>ProductDao</h1>
 * <p>Performs all product related database tasks using hibernate.<p>
 * @author Mukilan.K
 *
 * @version 1.0
 */
@Repository("productDao")
public class ProductDao extends GenericDao {

	/**
	 * Inserts product details into database.
	 * @param product
	 *     product object that has to be inserted into database.
     * @return True
     *     If product object is inserted.	
     * @throws ApplicationException
	 *     If there is any interruption occurred in the database.
	 */
    public boolean insertProduct(Product product) throws ApplicationException {
        Transaction transaction = null;
        try {
        	openSession();
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
    
    /**
     * Retrieves the product list present in the database.
     * @return List<Product>
     *     List of product objects to be returned.
     * @throws ApplicationException
     *     If there is any interruption occurred in the database.
     */  
    public List<Product> retrieveProductDetails() throws ApplicationException {
        try {
        	openSession();
            return session.createQuery("FROM Product").list(); 
        } catch (HibernateException e) {
            throw new ApplicationException("Some error occured while listing the details of all Products",e); 
        } finally {
            closeSession(session);  
        }
    }

    /**
     * Retrieves product object for the given name.
     * @param name
     *     name of the product to be found.
     * @return product
     *     product object to be retrieved.
     * @throws ApplicationException
     *     If there is any interruption occurred in the database.
     */
    public Product searchProductByName(String name) throws ApplicationException {
        Transaction transaction = null;
        try {
        	openSession();
           	transaction = session.beginTransaction();
            String sql = "SELECT * FROM Product WHERE name = :name";
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(Product.class);
            query.setParameter("name", name);
            Object object = query.list().get(0);
            Product productFromDao = (Product)object;
        	System.out.println(productFromDao);
            transaction.commit();
            return productFromDao;
         } catch (HibernateException e) {
        	 e.printStackTrace();
            throw new ApplicationException("Some error occured while viewing details of "
                                            +name,e); 
        } finally {
            closeSession(session); 
        }  
    }
    
    /**
     * Updates the product object into the database.
     * @param product
     *     product object to be updated.
     * @return True
     *     If product object is updated.
     * @throws ApplicationException
     *     If there is any interruption occurred in the database.
     */
    public boolean updateProduct(Product product) throws ApplicationException {
        Transaction transaction = null;
        try {
        	openSession();
            transaction = session.beginTransaction();
            session.update(product); 
            transaction.commit();
            return true;
        } catch (HibernateException e) {
            throw new ApplicationException("Some error occured while updating details of "+ 
            		                        product.getName(),e); 
        } finally {
            closeSession(session); 
        }
    }
    
    /**
     * Deletes entire product object from the database.
     * @param product
     *     product object to be deleted.
     * @return True 
     *     If product object is deleted.
     * @throws ApplicationException
     *     If there is any interruption occurred in the database.
     */    
    public boolean deleteProduct(Product product) throws ApplicationException {
        Transaction transaction = null;
        try {
        	openSession();
            transaction = session.beginTransaction();
            session.delete(product); 
            transaction.commit();
            return true;
        } catch (HibernateException e) {
            throw new ApplicationException("Some error occured while deleting the details of "+
            		                        product.getName(),e); 
        } finally {
            closeSession(session); 
        }	
    }

}
