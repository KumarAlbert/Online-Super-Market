/**
 * 
 */
package dao;

import org.hibernate.HibernateException; 
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;
import org.hibernate.Session; 

import service.GenericService;
import exception.ApplicationException;

/**
 * <h1>GenericDao</h1>
 *     This class handles the hibernate connections for all Dao classes.
 * @author  Mukilan.K
 * @since   2016-06-28
 */
public class GenericDao {
    protected static SessionFactory sessionFactory = null;
    protected Transaction transaction;
    static {
        startSessionFactory ();
    }
    
	private static void startSessionFactory()   {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            System.out.println("Session factory opened");
        } catch (HibernateException e) {
                GenericService.appendToFile(e);
        } 
    }

  /**
    * This method closees the session factory when it is not null.
    */
    protected static void endSessionFactory() throws ApplicationException {
        if (null != sessionFactory) {
            try {
                sessionFactory.close();
            } catch (HibernateException e) {
            	GenericService.appendToFile(e);
                throw new ApplicationException("Problem occured !!",e);
            }
        }
    }
    
  /**
    * This method is used to create session for every operation in EmployeeDao and ProjectDao class after checking sessionfactory object.
    * @throws ApplicationException
    *     If there is problem in creating session object.
    */
    protected Session createSession() throws ApplicationException {
        if(null != sessionFactory) {  
            try {
                return sessionFactory.openSession();
            } catch (HibernateException e) {
                throw new ApplicationException("Problem occured !!",e);
            }
        } else {
            throw new ApplicationException("Problem while creating session factory !!"); 
        }
    }
  
  /**
    * This method is used to close the session.
    * @throws ApplicationException
    *     If there problem in closing the session object.
    */  
    protected void closeSession(Session session) throws ApplicationException {
        try {
            session.close();
        } catch (HibernateException e) {
            throw new ApplicationException("Problem occured !!",e);
        }
    }
}
