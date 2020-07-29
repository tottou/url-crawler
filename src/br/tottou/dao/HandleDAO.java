package br.tottou.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.tottou.data.HibernateConnector;
import br.tottou.entity.Handle;

public class HandleDAO {

	
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
