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

import com.i2i.model.Subcategory;
import com.i2i.exception.ApplicationException;
/**
 * <p> 
 * @author Mukilan.K
 *
 * @version 1.0
 */
@Repository("subcategoryDao")
public class SubcategoryDao extends GenericDao {

    public boolean insertSubcategory(Subcategory subcategory) throws ApplicationException {
        Transaction transaction = null;
        try {
        	openSession();
            transaction = session.beginTransaction();
            session.save(subcategory);
            transaction.commit();
            return true;
        } catch (HibernateException e) {
            throw new ApplicationException("Some error occured while inserting details of category: "
                                            +subcategory.getName(),e);
        } finally {
            closeSession(session); 
        }
    }
    
    public List<Subcategory> retrieveSubcategoryDetails() throws ApplicationException {
        try {
        	openSession();
            return session.createQuery("FROM Subcategory").list(); 
        } catch (HibernateException e) {
            throw new ApplicationException("Some error occured while listing the details of all categories",e); 
        } finally {
            closeSession(session);  
        }
    }
    
    public Subcategory searchSubcategoryByName(String name) throws ApplicationException {
        try {  
        	openSession();
        String sql = "SELECT * FROM Subcategory WHERE name = :name";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Subcategory.class);
		query.setParameter("name", name);
		List<Subcategory> results = query.list();
            for(Subcategory subcategory : results){
        	    return subcategory;
            }
        } catch (HibernateException e) {
            throw new ApplicationException("Some error occured while viewing details of "
                                            +name,e); 
        } finally {
            closeSession(session);
        }  
        return null; 
    }
    
    public boolean updateSubcategory(Subcategory subcategory) throws ApplicationException {
        Transaction transaction = null;
        try {
        	openSession();
            transaction = session.beginTransaction();
            session.update(subcategory); 
            transaction.commit();
            return true;
        } catch (HibernateException e) {
            throw new ApplicationException("Some error occured while updating details of "+ 
            		                        subcategory.getName(),e); 
        } finally {
            closeSession(session); 
        }
    }
    
    public boolean deleteSubcategory(Subcategory subcategory) throws ApplicationException {
        Transaction transaction = null;
        try {
        	openSession();
            transaction = session.beginTransaction();
            session.delete(subcategory); 
            transaction.commit();
            return true;
        } catch (HibernateException e) {
            throw new ApplicationException("Some error occured while deleting the details of "+
            		                        subcategory.getName(),e); 
        } finally {
            closeSession(session); 
        }	
    }

}