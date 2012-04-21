package org.stip.library.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.stip.library.Model.StipBook;



@Repository
public class StipBookDAO {
//private static final Logger log = LoggerFactory
//	.getLogger(StipBookDAO.class);
private SessionFactory sessionFactory;
@Autowired
public void setSessionFactory(SessionFactory sessionFactory){
	this.sessionFactory=sessionFactory;
}
@Transactional
public void store(StipBook stipBook)
{
//log.debug("saving stipbook instance");
try {
	sessionFactory.getCurrentSession().saveOrUpdate(stipBook);	
//	log.debug("saving successful");
} catch (RuntimeException e) {
	// TODO: handle exception
//	log.error("save stipbook failed", e);
	throw e;
}

}
@Transactional
public StipBook merge(StipBook instance){
//log.debug("merge stipbook instance");	
try {
	StipBook result=(StipBook)sessionFactory.getCurrentSession().merge(instance);
//	log.debug("merge stipbook successful");
	return result;

} catch (RuntimeException e) {
	// TODO: handle exception
//	log.error("merge stipbook failed", e);
	throw e;
	
}
	
	
}
@Transactional
public List<StipBook> findByProperty(String propertyName, Object value) {
//	log.debug("finding StipBook instance with property: " + propertyName
//			+ ", value: " + value);
	try {
		String queryString = "from StipBook as model where model."
				+ propertyName + "="+"'"+value.toString()+"'";
		
//		log.debug(queryString);
		return sessionFactory.getCurrentSession().createQuery(queryString).list();
	} catch (RuntimeException re) {
//		log.error("find by property name failed", re);
		throw re;
	}
}


@Transactional
public void delete(Long stipBookID){
//	log.debug("deleting stipbook instance ");
	try {
		StipBook stipBook=(StipBook)sessionFactory.getCurrentSession().get(StipBook.class, stipBookID);
		sessionFactory.getCurrentSession().delete(stipBook);
	} catch (RuntimeException e) {
		// TODO: handle exception
//		log.error("delete stipbook failed", e);
		throw e;
	}
	
			
}
@Transactional(readOnly=true) 
public StipBook findBookByID(long stipBookID){
//	log.debug("find stipbook instance by id ");
	try {
		return  (StipBook)sessionFactory.getCurrentSession().get(StipBook.class, stipBookID);
	} catch (RuntimeException e) {
		// TODO: handle exception
//		log.error("find stipbook by id failed", e);
		throw e;
	}
	
	
}
@Transactional(readOnly=true)

public List<StipBook> findAll(){
//	log.debug("find stipbook all instance  ");
	try {
		Query query=sessionFactory.getCurrentSession().createQuery("from StipBook");
		return query.list();
	} catch (RuntimeException e) {
		// TODO: handle exception
//		log.error("find stipbook all failed", e);
		throw e;
	}
	
	
	
}
}
