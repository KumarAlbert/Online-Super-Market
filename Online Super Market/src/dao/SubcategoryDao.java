/**
 * 
 */
package dao;

import java.util.List;

import org.hibernate.HibernateException; 
import org.hibernate.Transaction;
import org.hibernate.Session; 


import model.Subcategory;
import exception.ApplicationException;
/**
 * <p> 
 * @author Mukilan.K
 *
 * @version 1.0
 */
public class SubcategoryDao extends GenericDao {

    public boolean insertSubcategory(Subcategory subcategory) throws ApplicationException {
        Session session = createSession();  
        Transaction transaction = null;
        try {
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
        Session session = createSession(); 
        try {
            return session.createQuery("FROM Subcategory").list(); 
        } catch (HibernateException e) {
            throw new ApplicationException("Some error occured while listing the details of all categories",e); 
        } finally {
            closeSession(session);  
        }
    }
    
    public Subcategory searchSubcategoryByName(String name) throws ApplicationException {
        Session session = createSession();  
        try {
            return (Subcategory)session.get(Subcategory.class, name);
        } catch (HibernateException e) {
            throw new ApplicationException("Some error occured while viewing details of "
                                            +name,e); 
        } finally {
            closeSession(session); 
        }  
    }
    
    public boolean updateSubcategory(Subcategory subcategory) throws ApplicationException {
        Session session = createSession();
        Transaction transaction = null;
        try {
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
        Session session = createSession();
        Transaction transaction = null;
        try {
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
