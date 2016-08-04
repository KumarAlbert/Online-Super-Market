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


import com.i2i.model.Category;
import com.i2i.model.User;
import com.i2i.exception.ApplicationException;
/**
 * @author Mukilan.K
 *
 * @version 1.0
 */
@Repository ("categoryDao")
public class CategoryDao extends GenericDao {

    public void insertCategory(Category category) throws ApplicationException { 
        Transaction transaction = null;
        try {
        	openSession();
            transaction = session.beginTransaction();
            session.save(category);
            transaction.commit();
        } catch (HibernateException e) {
            throw new ApplicationException("Some error occured while inserting details of category: "
                                            +category.getName(),e);
        } finally {
            closeSession(session); 
        }
    }
    
    public List<Category> retrieveCategoryDetails() throws ApplicationException {
        try {
        	openSession();
        	System.out.println("inside view all category");
            return session.createQuery("FROM Category").list(); 
        } catch (HibernateException e) {
            throw new ApplicationException("Some error occured while listing the details of all categories",e); 
        } finally {
            closeSession(session);  
        }
    }
    
    public Category searchCategoryByName(String name) throws ApplicationException {
        try {
        	openSession();
        String sql = "SELECT * FROM Category WHERE name = :name";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Category.class);
		query.setParameter("name", name);
		List<Category> results = query.list();
            for(Category category : results){
        	    return category;
            }
        } catch (HibernateException e) {
            throw new ApplicationException("Some error occured while viewing details of "
                                            +name,e); 
        } finally {
            closeSession(session);
        }  
        return null;
    }
    
    public boolean updateCategory(Category category) throws ApplicationException {
        Transaction transaction = null;
        try {
        	openSession();
            transaction = session.beginTransaction();
            session.update(category); 
            transaction.commit();
            return true;
        } catch (HibernateException e) {
            throw new ApplicationException("Some error occured while updating details of "+ 
            		                        category.getName(),e); 
        } finally {
            closeSession(session); 
        }
    }
    
    public boolean deleteCategory(Category category) throws ApplicationException {
        Transaction transaction = null;
        try {
        	openSession();
            transaction = session.beginTransaction();
            session.delete(category); 
            transaction.commit();
            return true;
        } catch (HibernateException e) {
            throw new ApplicationException("Some error occured while deleting the details of "+
            		                        category.getName(),e); 
        } finally {
            closeSession(session); 
        }	
    }
}