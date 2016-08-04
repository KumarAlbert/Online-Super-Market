/**
 * 
 */
package com.i2i.dao;

import org.hibernate.HibernateException; 
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session; 


import com.i2i.exception.ApplicationException;
import com.i2i.logger.Logger;
/**
 * <h1>GenericDao</h1>
 *     This class handles the hibernate connections for all Dao classes.
 * @author  Mukilan.K
 * @since   2016-06-28
 */

public class GenericDao {
    protected static SessionFactory sessionFactory = null;
	protected static Session session = null;

    
    static {
    	startSessionFactory();
    }
    
	public static void startSessionFactory()  {
		try {
        	sessionFactory =  new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		} catch (HibernateException e){
            
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
            	Logger.writeLog(e);
                throw new ApplicationException("Problem occured !!",e);
            }
        }
    }


    protected void openSession() {
        if (null != sessionFactory) {
        	session = sessionFactory.openSession();
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
