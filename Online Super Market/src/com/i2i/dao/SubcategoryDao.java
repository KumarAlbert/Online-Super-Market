/**
 * 
 */
package com.i2i.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.i2i.model.Subcategory;
import com.i2i.exception.ApplicationException;
/**
 * <h1>SubcategoryDao</h1>
 * <p>Performs all subcategory related database tasks using hibernate.<p>
 * @author Mukilan.K
 *
 * @version 1.0
 */
@Repository("subcategoryDao")
public class SubcategoryDao extends GenericDao {

	/**
	 * Inserts subcategory details into database.
	 * @param subcategory
	 *     subcategory object that has to be inserted into database.
     * @return True
     *     If subcategory object is inserted.	
     * @throws ApplicationException
	 *     If there is any interruption occurred in the database.
	 */
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
    
    /**
     * Retrieves the subcategory list present in the database.
     * @return List<Subcategory>
     *     List of subcategory objects to be returned.
     * @throws ApplicationException
     *     If there is any interruption occurred in the database.
     */ 
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
    
    /**
     * Retrieves subcategory object for the given name.
     * @param name
     *     name of the subcategory to be found.
     * @return subcategory
     *     subcategory object to be retrieved.
     * @throws ApplicationException
     *     If there is any interruption occurred in the database.
     */
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
    
    /**
     * Updates the subcategory object into the database.
     * @param subcategory
     *     subcategory object to be updated.
     * @return True
     *     If subcategory object is updated.
     * @throws ApplicationException
     *     If there is any interruption occurred in the database.
     */
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
    
    /**
     * Deletes entire subcategory object from the database.
     * @param subcategory
     *     subcategory object to be deleted.
     * @return True 
     *     If subcategory object is deleted.
     * @throws ApplicationException
     *     If there is any interruption occurred in the database.
     */  
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