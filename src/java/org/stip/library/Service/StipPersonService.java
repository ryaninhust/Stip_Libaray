/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.stip.library.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.stip.library.Dao.StipPersonInfoDAO;
import org.stip.library.Model.StipBorrwoList;
import org.stip.library.Model.StipListBookMap;
import org.stip.library.Model.StipPersonInfo;
import org.stip.library.Restmodel.Book_Library_School;
import org.stip.library.Restmodel.Person_Books;

/**
 *
 * @author ryanhust
 */
@Service
public class StipPersonService {
    public StipPersonInfoDAO stipPersonInfoDAO;
    
    @Autowired
    public void setStipPersonInfoDAO(StipPersonInfoDAO stipPersonInfoDAO) {
        this.stipPersonInfoDAO = stipPersonInfoDAO;
    }
    
    
    public Person_Books findPerson_Books(Long id){
    StipPersonInfo stipPersonInfo=  stipPersonInfoDAO.findById(id);
        if (stipPersonInfo!=null) {
            
           Set<StipBorrwoList> stipBorrwoLists=   stipPersonInfo.getStipBorrwoLists();
           List<Book_Library_School> blses=new ArrayList<Book_Library_School>();
            for (Iterator<StipBorrwoList> it = stipBorrwoLists.iterator(); it.hasNext();) {
                StipBorrwoList stipBorrwoList = it.next();
                Set<StipListBookMap>  stipListBookMaps= stipBorrwoList.getStipListBookMaps();
                
                for (Iterator<StipListBookMap> it1 = stipListBookMaps.iterator(); it1.hasNext();) {
                    
                    StipListBookMap stipListBookMap = it1.next();
                    if (stipListBookMap.getStatus()==1) {
                        Book_Library_School book_Library_School =new Book_Library_School(stipListBookMap.getStipBook().getId(), stipListBookMap.getStipBook().getStipBookInfo().getName(),stipListBookMap.getStipBook().getStipLibrary().getId() 
                                ,stipListBookMap.getStipBook().getStipLibrary().getName() , stipListBookMap.getStipBook().getStipLibrary().getStipSchool().getId(), stipListBookMap.getStipBook().getStipLibrary().getStipSchool().getName());
                        blses.add(book_Library_School);
                    }
                   
                    
                }
                
            }
          Person_Books person_Books=new Person_Books(stipPersonInfo.getName(), stipPersonInfo.getId(), blses);
          return  person_Books;    
        }
    return  null;
    }
}
