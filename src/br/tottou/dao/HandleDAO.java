package br.tottou.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.tottou.data.HibernateConnector;
import br.tottou.entity.Handle;

public class HandleDAO {

	
	
/*	
 * Caso não fosse usar hibernate.cfg.xml
 * 
	public Session getSession()
	{
		Configuration cfg = new Configuration()
				 .addClass(br.jus.tse.entity.Handle.class)				    
				    .setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect")
				    .setProperty("hibernate.connection.driver_class", "org.postgresql.Driver")
				    .setProperty("hibernate.connection.username", "dspace")
				    .setProperty("hibernate.connection.password", "dspace")
				    .setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/dspace5")
				    .setProperty("hibernate.show_sql", "true")
				    .setProperty("hibernate.format_sql", "true");
				 
			SessionFactory sessionFactory = cfg.buildSessionFactory();
			Session session = sessionFactory.openSession();
			return session;
	}	}*/
	
	public Handle getHandle(Long id) {
		
	    Session session =  HibernateConnector.getInstance().getSession();
        Handle handle= (Handle) session.get(Handle.class, id);
        session.close();
        return handle;
	}
	
	@SuppressWarnings("unchecked")
	public List<Handle> getAllHandle() {
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            Query query = session.createQuery("from Handle");
 
            @SuppressWarnings("rawtypes")
			List queryList = query.list();
            if (queryList != null && queryList.isEmpty()) {
                return null;
            } else {
                return  (List<Handle>) queryList;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
  
	}
	
}
