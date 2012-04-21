/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.stip.library.Service;

import java.util.Iterator;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.stip.library.Dao.StipBookInfoDAO;
import org.stip.library.Dao.StipSchoolDAO;
import org.stip.library.Model.StipBook;
import org.stip.library.Model.StipBookInfo;
import org.stip.library.Model.StipLibrary;
import org.stip.library.Model.StipSchool;
import org.stip.library.Restmodel.School_Book_Amount;

/**
 *
 * @author ryanhust
 */
@Service
public class StipSchoolService {
    public StipSchoolDAO stipSchoolDAO;
    public StipBookInfoDAO stipBookInfoDAO;
@Autowired
    public void setStipSchoolDAO(StipSchoolDAO stipSchoolDAO) {
        this.stipSchoolDAO = stipSchoolDAO;
    }
@Autowired
    public void setStipBookInfoDAO(StipBookInfoDAO stipBookInfoDAO) {
        this.stipBookInfoDAO = stipBookInfoDAO;
    }

   public School_Book_Amount getBookSchoolAmount(Long schoolId,String isbn){
  StipSchool  stipSchool=   stipSchoolDAO.findById(schoolId);
  StipBookInfo stipBookInfo=stipBookInfoDAO.findByID(isbn);
  Integer amount=0;
  Set<StipLibrary>  stipLibrarys=stipSchool.getStipLibraries();
       for (Iterator<StipLibrary> it = stipLibrarys.iterator(); it.hasNext();) {
           StipLibrary stipLibrary = it.next();
           Set<StipBook> stipBooks=   stipLibrary.getStipBooks();
           for (Iterator<StipBook> it1 = stipBooks.iterator(); it1.hasNext();) {
               StipBook stipBook = it1.next();
               if ( stipBook.getStipBookInfo().getIsbn() == null ? isbn == null : stipBook.getStipBookInfo().getIsbn().equals(isbn)) {
                   amount++;
               }
               
           }
       }
  School_Book_Amount school_Book_Amount=new School_Book_Amount(stipSchool.getName(),stipSchool.getId(),stipBookInfo.getIsbn(),stipBookInfo.getName() , amount);
   return  school_Book_Amount;
   } 
}
