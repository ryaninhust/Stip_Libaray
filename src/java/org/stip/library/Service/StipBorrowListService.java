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
import org.stip.library.Dao.StipBorrowListDAO;
import org.stip.library.Model.StipBorrwoList;
import org.stip.library.Model.StipListBookMap;
import org.stip.library.Restmodel.Book_Library_Simple;
import org.stip.library.Restmodel.BorrowList_Book_Library;

/**
 *
 * @author ryanhust
 */
@Service
public class StipBorrowListService {
    public  StipBorrowListDAO stipBorrowListDAO;
   @Autowired
    public void setStipBorrowListDAO(StipBorrowListDAO stipBorrowListDAO) {
        this.stipBorrowListDAO = stipBorrowListDAO;
    }
    public BorrowList_Book_Library listBorrowList(Long id){
    StipBorrwoList stipBorrwoList=stipBorrowListDAO.findByid(id);
    
        if (stipBorrwoList!=null) {
             Set<StipListBookMap> stipListBookMaps=stipBorrwoList.getStipListBookMaps();
            List<Book_Library_Simple>  blses=new ArrayList<Book_Library_Simple>();
             for (Iterator<StipListBookMap> it = stipListBookMaps.iterator(); it.hasNext();) {
                StipListBookMap stipListBookMap = it.next();
                stipListBookMap.getStipBook().getStipBookInfo().getName();
                Book_Library_Simple bls=new Book_Library_Simple(stipListBookMap.getStipBook().getStipBookInfo().getName(), stipListBookMap.getStipBook().getId(), stipListBookMap.getStipBook().getStipLibrary().getId(), stipListBookMap.getStipBook().getStipLibrary().getName(), stipListBookMap.getStipBook().getStipLibrary().getStipSchool().getId(),
                        stipListBookMap.getStipBook().getStipLibrary().getStipSchool().getName(), stipListBookMap.getStipBook().getStipLibrary().getStipSchool().getPhone());
                blses.add(bls);
            }
            BorrowList_Book_Library blbl=new BorrowList_Book_Library(stipBorrwoList.getId(), stipBorrwoList.getDate(), blses);
            return  blbl;
        }
   
    return  null;
    }
            
}
