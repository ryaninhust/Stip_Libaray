/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.stip.library.Restmodel;

/**
 *
 * @author ryanhust
 */
public class School_Book_Amount {
    public String schoolName;
    public Integer schoolId;
    public String bookName;
    public String bookISBN;
    public Integer amount;

    public School_Book_Amount(String schoolName, Integer schoolId, String bookName, String bookISBN, Integer amount) {
        this.schoolName = schoolName;
        this.schoolId = schoolId;
        this.bookName = bookName;
        this.bookISBN = bookISBN;
        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getBookISBN() {
        return bookISBN;
    }

    public void setBookISBN(String bookISBN) {
        this.bookISBN = bookISBN;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
    
}
