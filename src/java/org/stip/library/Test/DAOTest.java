/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.stip.library.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.stip.library.Dao.StipBookDAO;
import org.stip.library.Dao.StipBookInfoDAO;
import org.stip.library.Model.StipBook;
import org.stip.library.Model.StipBookInfo;

/**
 *
 * @author ryanhust
 */
public class DAOTest {

    /**
     * @param args the command line arguments
     */
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        ApplicationContext ac = new FileSystemXmlApplicationContext("/web/WEB-INF/persistence-beans.xml");  ;
        
        StipBookInfoDAO stipBookInfoDAO=  (StipBookInfoDAO)ac.getBean("stipBookInfoDAO");
        StipBookInfo stipBookInfo=new StipBookInfo("sad", "asda", "sadd", "sadas", "asdsad", null);
        
         stipBookInfoDAO.store(stipBookInfo);
        System.out.println(stipBookInfoDAO.findByProperty("isbn", "sad").size()); 
        System.out.println("su");
    }
}
