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
 * @author Mukilan.K
 *
 * @version 1.0
 */
public class SubCategoryDao extends GenericDao {

    public boolean insertSubCategory(Subcategory subcategory) throws ApplicationException {
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
    
    public List<Subcategory> viewAllSubCategorys() throws ApplicationException {
        Session session = createSession(); 
        try {
            return session.createQuery("FROM Subcategory").list(); 
        } catch (HibernateException e) {
            throw new ApplicationException("Some error occured while listing the details of all categorys",e); 
        } finally {
            closeSession(session);  
        }
    }
    
    public Subcategory viewASubCategory(int id) throws ApplicationException {
        Session session = createSession();  
        try {
            return (Subcategory)session.get(Subcategory.class, id);
        } catch (HibernateException e) {
            throw new ApplicationException("Some error occured while viewing details of "
                                            +id,e); 
        } finally {
            closeSession(session); 
        }  
    }
    
    public boolean updateSubCategoryDetails(Subcategory subcategory) throws ApplicationException {
        Session session = createSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(subcategory); 
            transaction.commit();
            return true;
        } catch (HibernateException e) {
            throw new ApplicationException("Some error occured while updating details of "+ 
            		                        subcategory.getId(),e); 
        } finally {
            closeSession(session); 
        }
    }
    
    public boolean deleteASubCategory(Subcategory subcategory) throws ApplicationException {
        Session session = createSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(subcategory); 
            transaction.commit();
            return true;
        } catch (HibernateException e) {
            throw new ApplicationException("Some error occured while deleting the details of "+
            		                        subcategory.getId(),e); 
        } finally {
            closeSession(session); 
        }	
    }

}
