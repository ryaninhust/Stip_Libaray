/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.stip.library.Restmodel;

/**
 *
 * @author ryanhust
 */
public    class Book_User {
    public String bookName;
    public Integer bookId;
    public Integer personId;
    public String personName;

    public Book_User(String bookName, Integer bookId, Integer personId, String personName) {
        this.bookName = bookName;
        this.bookId = bookId;
        this.personId = personId;
        this.personName = personName;
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
    
}
