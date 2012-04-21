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
import org.stip.library.Model.StipListBookMap;

/**
 *
 * @author ryanhust
 */
@Repository
public class StipListBookMapDAO {
//    private static final Logger log=LoggerFactory.getLogger(StipListBookMapDAO.class);
    private SessionFactory sessionFactory;
    @Autowired

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Transactional
    public  void store(StipListBookMap instance){
//    log.debug("storing stiplistbookmap ");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
//            log.debug("storing stiplistbookmap successful");
        } catch (RuntimeException e) {
        
//        log.debug("storing stiplistbookmap failed",e);
        throw  e;
        }
    
    }
    @Transactional
    public StipListBookMap merge(StipListBookMap instance){
//    log.debug("merging stiplistbookmap ");
        try {
            
            StipListBookMap stipListBookMap=(StipListBookMap)sessionFactory.getCurrentSession().merge(instance);
            
//            log.debug("merging stiplistbookmap successful");
            return  stipListBookMap;
        } catch (RuntimeException e) {
//        log.error("merging stiplistbookmap failed",e);
        throw  e;
        
        }
    
    }
    @Transactional
    public void delete ( Long id ){
//    log.debug("deleting stiplistbookmap");
        try {
            StipListBookMap stipListBookMap=(StipListBookMap)sessionFactory.getCurrentSession().get(StipListBookMap.class, id);
            sessionFactory.getCurrentSession().delete(stipListBookMap);
//            log.debug("deleting stiplistbookmap success");
            
        } catch (RuntimeException e) {
//            log.error("deleting stipbooklistmap failed");
            throw  e;
        }
    
    }
    @Transactional(readOnly = true)
public List<StipListBookMap> findByProperty(String propertyName, Object value) {
//	log.debug("finding StipListBookMap instance with property: " + propertyName
//			+ ", value: " + value);
	try {
		String queryString = "from StipListBookMap as model where model."
				+ propertyName + "="+"'"+value.toString()+"'";
		
//		log.debug(queryString);
		return sessionFactory.getCurrentSession().createQuery(queryString).list();
	} catch (RuntimeException re) {
//		log.error("find by property name failed", re);
		throw re;
	}
}
//@Transactional(readOnly=true)
public List<StipListBookMap>findAll(){
//log.debug("find all stiplistbookmap instance");
    try {
      Query query=   sessionFactory.getCurrentSession().createQuery("from StipListBookMap");
//      log.debug("find all stiplistbookmap instance successful");
      return  query.list();
    } catch (RuntimeException e) {
//        log.error("find all stiplistbookmap instance failed",e);
        throw  e;
    }

}
@Transactional(readOnly=true)
public StipListBookMap findByID(Long id){
//log.debug("find stiplistbookmap by id");
    try {
        StipListBookMap stipListBookMap=(StipListBookMap) sessionFactory.getCurrentSession().get(StipListBookMap.class, id);
//        log.debug("find stiplistbookmap by id successful");
        return  stipListBookMap;
    } catch (RuntimeException e) {
//        log.error("find stiplistbookmap by id failed",e);
        throw e;
    }

}
}
