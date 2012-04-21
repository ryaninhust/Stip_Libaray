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
import org.stip.library.Model.StipPersonInfo;

/**
 *
 * @author ryanhust
 */
@Repository
public class StipPersonInfoDAO {
//   private  static  final Logger log= LoggerFactory.getLogger(StipPersonInfoDAO.class);
   private SessionFactory sessionFactory;
@Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
   @Transactional
   public void store(StipPersonInfoDAO instance){
//   log.debug("storing stippersoninfo ");
       try {
             this.sessionFactory.getCurrentSession().saveOrUpdate(instance);
//         log.debug("storing stippersoninfo successful");
       } catch (RuntimeException e) {
//           log.error("storing stippersoninfo failed",e);
           throw  e;
       }
 
   }
   
       @Transactional
      public StipPersonInfo merge(StipPersonInfo instance){
//       log.debug("merging stippersoninfo");
       try {
          StipPersonInfo stipPersonInfo1=   (StipPersonInfo) this.sessionFactory.getCurrentSession().merge(instance);
//          log.debug("merging stippersoninfo successful");
          return stipPersonInfo1;
       } catch (RuntimeException e) {
//           log.error("merging stippersoninfo failed",e);
           throw e;
       }
       
       
   }
   @Transactional        
   public void delete(Long id){
//   log.debug("deleting stippersoninfo ");
       try {
           this.sessionFactory.getCurrentSession().delete(this.sessionFactory.getCurrentSession().get(StipPersonInfo.class, id));
//           log.debug("deleting stippersoninfo successful");
       } catch (RuntimeException e) {
           
//           log.error("deleti/ng stippersoninfo failed",e);
           throw  e;
       }
   
   }
    @Transactional(readOnly = true)
public List<StipPersonInfo> findByProperty(String propertyName, Object value) {
//	log.debug("finding StipPersonInfo instance with property: " + propertyName
//			+ ", value: " + value);
	try {
		String queryString = "from StipPersonInfo as model where model."
				+ propertyName + "="+"'"+value.toString()+"'";
		
//		log.debug(queryString);
		return sessionFactory.getCurrentSession().createQuery(queryString).list();
	} catch (RuntimeException re) {
//		log.error("find by property name failed", re);
		throw re;
	}
}
@Transactional    
public StipPersonInfo findById(Long id){
//log.debug("finding stippersoninfo by id ");
    try {
        StipPersonInfo stipPersonInfo=(StipPersonInfo) this.sessionFactory.getCurrentSession().get(StipPersonInfo.class, id);
//        log.debug("finding stipppersoninfo by id successful ");
        return  stipPersonInfo;
    } catch (RuntimeException e) {
//    log.error("find by id stippersoninfo failed",e);
    throw  e;
    
    }

}
@Transactional 
public List<StipPersonInfo> findAll(){
//log.debug("finding all stippersoninfo instance");
    try {
        Query query= this.sessionFactory.getCurrentSession().createQuery("from StipPersonInfo");
//        log.debug("find all stippersoninfo instance success ");
        return  query.list();
    } catch (RuntimeException e) {
//        log.error("find all sitppersoninfo failed",e);
        throw e;
    }
}
}
