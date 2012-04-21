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
import org.stip.library.Dao.StipBookDAO;
import org.stip.library.Dao.StipBookInfoDAO;
import org.stip.library.Model.StipBook;
import org.stip.library.Model.StipBookInfo;
import org.stip.library.Model.StipLibrary;
import org.stip.library.Model.StipListBookMap;
import org.stip.library.Model.StipPersonInfo;
import org.stip.library.Restmodel.Book_Library;
import org.stip.library.Restmodel.Book_User_School;
import org.stip.library.Restmodel.Library_Amount_School;

/**
 *
 * @author ryanhust
 */
@Service
public class StipBookService {
    public StipBookInfoDAO stipBookInfoDAO;
    public StipBookDAO stipBookDAO;
    
    @Autowired
    public void setStipBookInfoDAO(StipBookInfoDAO stipBookInfoDAO) {
        this.stipBookInfoDAO = stipBookInfoDAO;
    }
    @Autowired
    public void setStipBookDAO(StipBookDAO stipBookDAO) {
        this.stipBookDAO = stipBookDAO;
    }
    
    
    public List<Book_Library>  findBookByName(String bookName){
    List<StipBookInfo> stipBookInfos=stipBookInfoDAO.findByProperty("name", bookName);
       
       List<Book_Library> book_Librarys=new ArrayList<Book_Library>();
        for (Iterator<StipBookInfo> it = stipBookInfos.iterator(); it.hasNext();) {
            StipBookInfo stipBookInfo = it.next();
                Set<StipBook> stipBooks=stipBookInfo.getStipBooks();
                 List<Library_Amount_School> library_Amount_Schools=new ArrayList<Library_Amount_School>();
                for (Iterator<StipBook> it1 = stipBooks.iterator(); it1.hasNext();) {
                StipBook stipBook = it1.next();
                Integer amount=0;
                
                 StipLibrary stipLibrary=stipBook.getStipLibrary();
                 
                 Set<StipBook> library_Books=stipLibrary.getStipBooks();
                 
                    for (Iterator<StipBook> it2 = library_Books.iterator(); it2.hasNext();) {
                        StipBook stipBook1 = it2.next();
                        if (stipBook1.getStipBookInfo().equals(stipBookInfo)) {
                            amount++;
                        }
                    }
                    Library_Amount_School library_Amount_School=new Library_Amount_School(stipLibrary.getName(), amount, stipLibrary.getStipSchool().getName());
                    library_Amount_Schools.add(library_Amount_School);
                
            }
             
              Book_Library      book_Library=new Book_Library(stipBookInfo.getName(), library_Amount_Schools);
            book_Librarys.add(book_Library);
        }
       
        return  book_Librarys;
    }
    public Book_User_School findBook_User(Long id){
    StipBook stipBook=stipBookDAO.findBookByID(id);
    
        if (stipBook!=null) {
            Set<StipListBookMap> stipListBookMaps=stipBook.getStipListBookMaps();
            StipListBookMap findInstance=null; 
            for (Iterator<StipListBookMap> it = stipListBookMaps.iterator(); it.hasNext();) {
                StipListBookMap stipListBookMap = it.next();
                if (stipListBookMap.getStatus()==1) {
                    findInstance=stipListBookMap;
                    break;
                }
            }
            if (findInstance!=null) {
              StipPersonInfo stipPersonInfo=   findInstance.getStipBorrwoList().getStipPersonInfo();
              Book_User_School book_User_School=new Book_User_School(stipPersonInfo.getName(), stipPersonInfo.getId(), stipPersonInfo.getMajor(), stipBook.getStipBookInfo().getName(), stipBook.getId());
              return  book_User_School;
            }
        }
        return  null;
    }
}
