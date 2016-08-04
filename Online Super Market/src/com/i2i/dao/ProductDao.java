/**
 * 
 */
package com.i2i.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.hibernate.Session;

import com.i2i.model.Product;
import com.i2i.model.Subcategory;
import com.i2i.exception.ApplicationException;
/**
 * @author Mukilan.K
 *
 * @version 1.0
 */
@Repository("productDao")
public class ProductDao extends GenericDao {

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
    
    public Product searchProductByName(String name) throws ApplicationException {
        Transaction transaction = null;
        try {
        	openSession();
        	System.out.println(session);
        	System.out.println("inside product dao");
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
