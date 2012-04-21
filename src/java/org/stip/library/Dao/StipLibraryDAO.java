/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.stip.library.Dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.stip.library.Model.StipLibrary;

/**
 *
 * @author ryanhust
 */
@Repository
public class StipLibraryDAO {
//    private static final Logger log=LoggerFactory.getLogger(StipLibraryDAO.class);
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Transactional
    public void store(StipLibrary instance){
//    log.debug("storing stiplibrary now");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
//            log.debug("storing stiplibrary successful");
        } catch (RuntimeException e) {
//            log.error("storing stiplibrary failed",e);
            throw e;
        }
    
    }
    @Transactional
    public StipLibrary merge(StipLibrary instance){
//    log.debug("merging stiplibrary now");
        try {
          StipLibrary stipLibrary=   (StipLibrary) sessionFactory.getCurrentSession().merge(instance);
//          log.debug("merging stiplibrary successful");
          return  stipLibrary;
        } catch (RuntimeException e) {
//            log.error("merging stiplibrary failed",e);
            throw  e;
        }
    
    }
    @Transactional
    public void delete(StipLibrary instance){
//    log.debug("deleting stiplibrary now");
        try {
            sessionFactory.getCurrentSession().delete(instance);
//            log.debug("deleting stiplibrary successful");
        } catch (RuntimeException e) {
//            log.error("deleting stiplibrary failed",e);
            throw e;
        }
    
    
    }
@Transactional(readOnly=true)
public List<StipLibrary> findByProperty(String propertyName, Object value) {
//	log.debug("finding StipLibrary instance with property: " + propertyName
//			+ ", value: " + value);
	try {
		String queryString = "from StipLibrary as model where model."
				+ propertyName + "="+"'"+value.toString()+"'";
		
//		log.debug(queryString);
		return sessionFactory.getCurrentSession().createQuery(queryString).list();
	} catch (RuntimeException re) {
//		log.error("find by property name failed", re);
		throw re;
	}
}
@Transactional(readOnly=true)
public StipLibrary findById(Long id){
//log.debug("finding stiplibrary instance by id");
    try {
        StipLibrary stipLibrary=(StipLibrary)sessionFactory.getCurrentSession().get(StipLibrary.class, id);
//        log.debug("finding stiplibrary instance by id sucessful");
        return  stipLibrary;
    } catch (RuntimeException e) {
//        log.error("finding findlibrary instance by id failed",e);
        throw e;
    }
    
}
@Transactional(readOnly=true)
public List<StipLibrary> findAll(){
//log.debug("finding all stiplibrary instance");
    try {
        Query query=sessionFactory.getCurrentSession().createQuery("from StipLibrary");
//        log.debug("finding all stiplibrary instances successful");
        return  query.list();
        
    } catch (RuntimeException e) {
//        log.error("finding al/l stiplibrary instances failed",e);
        throw  e;
    }
}
}
