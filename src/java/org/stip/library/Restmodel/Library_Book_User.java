/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.stip.library.Restmodel;

import java.util.List;

/**
 *
 * @author ryanhust
 */
public class Library_Book_User {
 public  Integer libraryId;
 public String libraryName;
 public List<Book_User> book_Users;

    public Library_Book_User(Integer libraryId, String libraryName, List<Book_User> book_Users) {
        this.libraryId = libraryId;
        this.libraryName = libraryName;
        this.book_Users = book_Users;
    }

    public List<Book_User> getBook_Users() {
        return book_Users;
    }

    public void setBook_Users(List<Book_User> book_Users) {
        this.book_Users = book_Users;
    }

    public Integer getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Integer libraryId) {
        this.libraryId = libraryId;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }
 
}
