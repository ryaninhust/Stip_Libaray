package org.stip.library.Dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
//import org.slf4j.//logger;
//import org.slf4j.//loggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.stip.library.Model.StipBorrwoList;

@Repository
public class StipBorrowListDAO {
//	private static final //logger //log = //loggerFactory
//	.get//logger(StipBorrowListDAO.class);
private SessionFactory sessionFactory;
@Autowired
public void setSessionFactory(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
}
@Transactional
public void store(StipBorrwoList instance){
	//log.debug("storing the stipborrowlist instance");
	   try {
        sessionFactory.getCurrentSession().saveOrUpdate(instance);
        //log.debug("store stipborrowlist successfully");
    } catch (RuntimeException e) {
        //log.error("store stipborrowlist failed ",e);
        throw  e;
    }
	
	
	
}
@Transactional
public StipBorrwoList merge(StipBorrwoList instance){
//log.debug("merge stipborrowlist ");
    try {
        StipBorrwoList stipBorrwoList=(StipBorrwoList) sessionFactory.getCurrentSession().merge(instance);
        //log.debug("merge stipborrowlist sucessfully");
        return  stipBorrwoList;
    } catch (RuntimeException e) {
        //log.error("merge stipborrowlist failed ",e);
        throw  e;
    }

}

@Transactional(readOnly = true)
public List<StipBorrwoList> findByProperty(String propertyName, Object value) {
	//log.debug("finding StipBorrowList instance with property: " + propertyName
//			+ ", value: " + value);
	try {
		String queryString = "from StipBorrowList as model where model."
				+ propertyName + "="+"'"+value.toString()+"'";
		
		//log.debug(queryString);
		return sessionFactory.getCurrentSession().createQuery(queryString).list();
	} catch (RuntimeException re) {
		//log.error("find by property name failed", re);
		throw re;
	}
}
@Transactional
public void delete(Long id){
//log.debug("deleting sitpborrow instance ");
    try {
        StipBorrwoList stipBorrwoList=(StipBorrwoList)sessionFactory.getCurrentSession().get(StipBorrwoList.class, id);
        sessionFactory.getCurrentSession().delete(stipBorrwoList);
        //log.debug("deleting stipborrowlist successfully");
    } catch (RuntimeException e) {
        //log.error("deleting stipborrowlist failed ", e);
        throw e;
    }
}
@Transactional(readOnly=true)
public StipBorrwoList findByid(Long id){
//log.debug("find stipborrow instance by id");
            try {
                StipBorrwoList stipBorrwoList=(StipBorrwoList)sessionFactory.getCurrentSession().get(StipBorrwoList.class, id);
                //log.debug("find stipborrow instance by id successful");
                return  stipBorrwoList;
            } catch (RuntimeException e) {
                //log.error("find stipborrow instance by id failed",e);
                throw  e;
            }

}
@Transactional(readOnly=true)
public List<StipBorrwoList> findAll(){
//log.debug("find all stipborrow instances");
    try {
        Query query=sessionFactory.getCurrentSession().createQuery("from StipBorrow");
        //log.debug("find all stipborrow instances successful");
        return  query.list();
    } catch (RuntimeException e) {
        //log.error("find all stipborrow instance failed ",e);
        throw e;
    }

}
}
