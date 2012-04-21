/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.stip.library.Restmodel;

import java.util.Date;
import java.util.List;

/**
 *
 * @author ryanhust
 */
public class BorrowList_Book_Library {
  public  Integer  borrowId;  
  public  Date  borrowDate;
  public List<Book_Library_Simple> book_Librarys;

    public BorrowList_Book_Library(Integer borrowId, Date borrowDate, List<Book_Library_Simple> book_Librarys) {
        this.borrowId = borrowId;
        this.borrowDate = borrowDate;
        this.book_Librarys = book_Librarys;
    }

    public List<Book_Library_Simple> getBook_Librarys() {
        return book_Librarys;
    }

    public void setBook_Librarys(List<Book_Library_Simple> book_Librarys) {
        this.book_Librarys = book_Librarys;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Integer getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(Integer borrowId) {
        this.borrowId = borrowId;
    }
  
}
