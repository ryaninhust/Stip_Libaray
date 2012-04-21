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
import org.stip.library.Dao.StipLibraryDAO;
import org.stip.library.Model.StipBook;
import org.stip.library.Model.StipLibrary;
import org.stip.library.Model.StipListBookMap;
import org.stip.library.Restmodel.Book_User;
import org.stip.library.Restmodel.Library_Book_User;

/**
 *
 * @author ryanhust
 */
@Service
public class StipLibraryService {
    public StipLibraryDAO stipLibraryDAO;
    
    @Autowired
    public void setStipLibraryDAO(StipLibraryDAO stipLibraryDAO) {
        this.stipLibraryDAO = stipLibraryDAO;
    }
    public Library_Book_User findLibaryBook_User(Long id){
    StipLibrary stipLibrary= stipLibraryDAO.findById(id);
        if (stipLibrary!=null) {
           List<Book_User> book_Users=new ArrayList<Book_User>();
           Set<StipBook> stipBooks=stipLibrary.getStipBooks();
            for (Iterator<StipBook> it = stipBooks.iterator(); it.hasNext();) {
                StipBook stipBook = it.next();
                Set<StipListBookMap> stipListBookMaps = stipBook.getStipListBookMaps();
                StipListBookMap stipListBookMap=null;
                for (Iterator<StipListBookMap> it1 = stipListBookMaps.iterator(); it1.hasNext();) {
                    StipListBookMap stipListBookMaptem = it1.next();
                    if(stipListBookMaptem.getStatus()==1){
                    stipListBookMap=stipListBookMaptem;
                    
                    }
                                   
                }
                if (stipListBookMap!=null) {
                    Book_User book_User=new Book_User(stipBook.getStipBookInfo().getName(), stipBook.getId(), stipListBookMap.getStipBorrwoList().getStipPersonInfo().getId(), stipListBookMap.getStipBorrwoList().getStipPersonInfo().getName());
                    book_Users.add(book_User);
                }
            }
           Library_Book_User library_Book_User=new Library_Book_User(stipLibrary.getId(), stipLibrary.getName(), book_Users) ;
           return  library_Book_User;
        }
    return  null;
    }
    
}
