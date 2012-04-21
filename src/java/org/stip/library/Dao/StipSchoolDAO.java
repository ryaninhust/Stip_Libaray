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
import org.stip.library.Model.StipSchool;

/**
 *
 * @author ryanhust
 */
@Repository
public class StipSchoolDAO {
//       private  static  final Logger log= LoggerFactory.getLogger(StipPersonInfoDAO.class);
   private SessionFactory sessionFactory;
@Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
@Transactional
public void store(StipSchool instance){
//log.debug("storing stipschool instance");
    try {
        this.sessionFactory.getCurrentSession().saveOrUpdate(instance);
//        log.debug("storing stipshool success");
    } catch (RuntimeException e) {
//        log.error("storing stipshool failed",e);
        throw  e;
    }
    

}
@Transactional
public  StipSchool merge(StipSchool instance){
//log.debug("merging stipschool instance");
    try {
       StipSchool    stipSchool  =(StipSchool) this.sessionFactory.getCurrentSession().merge(instance);
//       log.debug("merging stipschool instance successful");
       return  stipSchool;
    } catch (RuntimeException e) {
//        log.error("merging stipschool instance failed",e);
        throw e;
    }

}
@Transactional
public void delete(Long id){
//log.debug("deleting stipschool instance ");
    try {
         StipSchool school=(StipSchool)this.sessionFactory.getCurrentSession().get(StipSchool.class, id);
         this.sessionFactory.getCurrentSession().delete(school);
//         log.debug("deleting stipshcool instance successful");
    } catch (RuntimeException e) {
//        log.error("deleting stipschool instance failed",e);
    }

}
    @Transactional(readOnly = true)
public List<StipSchool> findByProperty(String propertyName, Object value) {
//	log.debug("finding StipSchool instance with property: " + propertyName
//			+ ", value: " + value);
	try {
		String queryString = "from StipSchool as model where model."
				+ propertyName + "="+"'"+value.toString()+"'";
		
//		log.debug(queryString);
		return sessionFactory.getCurrentSession().createQuery(queryString).list();
	} catch (RuntimeException re) {
//		log.error("find by property name failed", re);
		throw re;
	}
}
    @Transactional(readOnly=true)    
public StipSchool findById(Long id){
//log.debug("finding StipSchool by id ");
    try {
        StipSchool stipPersonInfo=(StipSchool) this.sessionFactory.getCurrentSession().get(StipSchool.class, id);
//        log.debug("finding StipSchool by id successful ");
        return  stipPersonInfo;
    } catch (RuntimeException e) {
//    log.error("find by id StipSchool failed",e);
    throw  e;
    
    }
    

}
    @Transactional(readOnly=true)
public List<StipSchool>findAll(){
//log.debug("find all StipSchool instance");
    try {
      Query query=   sessionFactory.getCurrentSession().createQuery("from StipSchool");
//      log.debug("find all StipSchool instance successful");
      return  query.list();
    } catch (RuntimeException e) {
//        log.error("find all StipSchool instance failed",e);
        throw  e;
    }

}
}
