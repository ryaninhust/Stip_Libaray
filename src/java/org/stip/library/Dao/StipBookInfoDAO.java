package org.stip.library.Dao;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.SessionFactory;

//import org.slf4j.//logger;
//import org.slflog4j.//loggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.stip.library.Model.StipBookInfo;

@Repository
public class StipBookInfoDAO {
	private SessionFactory sessionFactory;
//	private static final //logger //log = //loggerFactory
//	.get//logger(StipBookInfoDAO.class);
@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
@Transactional
public void store(StipBookInfo stipBookInfo){
	//log.debug("storing stipbookinfo instance");
	try {
		
		sessionFactory.getCurrentSession().saveOrUpdate(stipBookInfo);
		//log.debug("store stipbookinfo successful");
	} catch (RuntimeException e) {
		
		// TODO: handle exception
		
		//log.error("store stipbookinfo failed", e);
		throw e;
	}
	
}
@Transactional 
public StipBookInfo merge(StipBookInfo instance){
	//log.debug("merge stipbookinfo instance");
	try {
	StipBookInfo stipBookInfo=(StipBookInfo)sessionFactory.getCurrentSession().merge(instance);
	//log.debug("merge successful");
	return stipBookInfo;
	} catch (RuntimeException e) {
		// TODO: handle exception
		//log.error("merge stipinfo error",e);
		throw e;
	}
}
@Transactional(readOnly = true)
public List<StipBookInfo> findByProperty(String propertyName, Object value) {
	//log.debug("finding StipBookInfo instance with property: " + propertyName
//			+ ", value: " + value);
	try {
		String queryString = "from StipBookInfo as model where model."
				+ propertyName + "="+"'"+value.toString()+"'";
		System.out.println(queryString);
		//log.debug(queryString);
		return sessionFactory.getCurrentSession().createQuery(queryString).list();
	} catch (RuntimeException re) {
		//log.error("find by property name failed", re);
		throw re;
	}
}
@Transactional
public void delete(String isbn){
	//log.debug("deleting StipBookInfo instance");
	try {
	StipBookInfo stipBookInfo=(StipBookInfo) sessionFactory.getCurrentSession().get(StipBookInfo.class, isbn);
	sessionFactory.getCurrentSession().delete(stipBookInfo);
	//log.debug("delete stipbookinfo sucessful");
	} catch (RuntimeException e) {
		// TODO: handle exception
		//log.error("delete stipbookinfo failed");
		throw e;
	}

	
}
@Transactional(readOnly = true)
public StipBookInfo findByID(String isbn){
	//log.debug("deleting stipbookinfo instance");
	try {
		StipBookInfo stipBookInfo=(StipBookInfo)sessionFactory.getCurrentSession().get(StipBookInfo.class, isbn);
		//log.debug("find by id stipbookinfo successful");
		return stipBookInfo;
	} catch (RuntimeException e) {
		// TODO: handle exception
		//log.error("find by id stipbookinfo failed");
		throw e;
		
	}
	
}
@Transactional(readOnly = true)
public List<StipBookInfo> findAll(){
	//log.debug("find all stipbookinfo instance");
	try {
		Query query=sessionFactory.getCurrentSession().createQuery("from StipBookInfo");
		//log.debug("find all stipbookinfo successful");
		return query.list();
	} catch (RuntimeException e) {
		// TODO: handle exception
		//log.error("find all stipbookinfo failed");
		throw e;
		
	}
	
}
}
