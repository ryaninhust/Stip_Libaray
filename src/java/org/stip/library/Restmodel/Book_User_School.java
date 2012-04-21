/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.stip.library.Restmodel;

/**
 *
 * @author ryanhust
 */
public class Book_User_School {
    public String   personName;
    public Integer personId;   
    public String  personSchool ;
    public String  bookName;
    public Integer bookId;

    public Book_User_School(String personName, Integer personId, String personSchool, String bookName, Integer bookId) {
        this.personName = personName;
        this.personId = personId;
        this.personSchool = personSchool;
        this.bookName = bookName;
        this.bookId = bookId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonSchool() {
        return personSchool;
    }

    public void setPersonSchool(String personSchool) {
        this.personSchool = personSchool;
    }
    
}
