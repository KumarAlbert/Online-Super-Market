/**
 * 
 */
package dao;

import java.util.List;

import org.hibernate.HibernateException; 
import org.hibernate.Transaction;
import org.hibernate.Session; 


import model.Category;
import exception.ApplicationException;
/**
 * @author Mukilan.K
 *
 * @version 1.0
 */
public class CategoryDao extends GenericDao {

    public boolean insertCategory(Category category) throws ApplicationException {
        Session session = createSession();  
        Transaction transaction = null;
        try {
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
    
    public List<Category> viewAllCategorys() throws ApplicationException {
        Session session = createSession(); 
        try {
            return session.createQuery("FROM Category").list(); 
        } catch (HibernateException e) {
            throw new ApplicationException("Some error occured while listing the details of all categorys",e); 
        } finally {
            closeSession(session);  
        }
    }
    
    public Category viewACategory(int id) throws ApplicationException {
        Session session = createSession();  
        try {
            return (Category)session.get(Category.class, id);
        } catch (HibernateException e) {
            throw new ApplicationException("Some error occured while viewing details of "
                                            +id,e); 
        } finally {
            closeSession(session); 
        }  
    }
    
    public boolean updateCategoryDetails(Category category) throws ApplicationException {
        Session session = createSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(category); 
            transaction.commit();
            return true;
        } catch (HibernateException e) {
            throw new ApplicationException("Some error occured while updating details of "+ 
            		                        category.getId(),e); 
        } finally {
            closeSession(session); 
        }
    }
    
    public boolean deleteACategory(Category category) throws ApplicationException {
        Session session = createSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(category); 
            transaction.commit();
            return true;
        } catch (HibernateException e) {
            throw new ApplicationException("Some error occured while deleting the details of "+
            		                        category.getId(),e); 
        } finally {
            closeSession(session); 
        }	
    }
}
