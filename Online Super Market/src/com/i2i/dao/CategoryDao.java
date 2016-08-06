/**
 * 
 */
package com.i2i.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.i2i.model.Category;
import com.i2i.exception.ApplicationException;
/**
 * <h1>CategoryDao</h1>
 * <p>Performs all user related database tasks using hibernate.<p>
 * @author Mukilan.K
 *
 * @version 1.0
 */
@Repository ("categoryDao")
public class CategoryDao extends GenericDao {

	/**
	 * Inserts category details into database.
	 * @param category
	 *     category object that has to be inserted into database.
     * @return True
     *     If category object is inserted.	
     * @throws ApplicationException
	 *     If there is any interruption occurred in the database.
	 */
    public boolean insertCategory(Category category) throws ApplicationException { 
        Transaction transaction = null;
        try {
        	openSession();
            transaction = session.beginTransaction();
            session.save(category);
            transaction.commit();
            return true;
        } catch (HibernateException e) {
            throw new ApplicationException("Some error occured while inserting details of category: "
                                            +category.getName(),e);
        } finally {
            closeSession(session); 
        }
    }
    
    /**
     * Retrieves the category list present in the database.
     * @return List<Category>
     *     List of category objects to be returned.
     * @throws ApplicationException
     *     If there is any interruption occurred in the database.
     */
	public List<Category> retrieveCategoryDetails() throws ApplicationException {
        try {
        	openSession();
            return session.createQuery("FROM Category").list(); 
        } catch (HibernateException e) {
            throw new ApplicationException("Some error occured while listing the details of all categories",e); 
        } finally {
            closeSession(session);  
        }
    }
    
    /**
     * Retrieves Category object for the given name.
     * @param name
     *     name of the category to be found.
     * @return Category
     *     category object to be retrieved.
     * @throws ApplicationException
     *     If there is any interruption occurred in the database.
     */
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
    
    /**
     * Updates the category object into the database.
     * @param category
     *     category object to be updated.
     * @return True
     *     If category object is updated.
     * @throws ApplicationException
     *     If there is any interruption occurred in the database.
     */
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
    
    /**
     * Deletes entire category object from the database.
     * @param category
     *     category object to be deleted.
     * @return True 
     *     If category object is deleted.
     * @throws ApplicationException
     *     If there is any interruption occurred in the database.
     */
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