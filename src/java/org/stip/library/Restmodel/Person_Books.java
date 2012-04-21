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
public class Person_Books {
 public String personName   ;
 public Integer PersonId;
 public List<Book_Library_School> book_Library_Schools;

    public Person_Books(String personName, Integer PersonId, List<Book_Library_School> book_Library_Schools) {
        this.personName = personName;
        this.PersonId = PersonId;
        this.book_Library_Schools = book_Library_Schools;
    }

    public Integer getPersonId() {
        return PersonId;
    }

    public void setPersonId(Integer PersonId) {
        this.PersonId = PersonId;
    }

    public List<Book_Library_School> getBook_Library_Schools() {
        return book_Library_Schools;
    }

    public void setBook_Library_Schools(List<Book_Library_School> book_Library_Schools) {
        this.book_Library_Schools = book_Library_Schools;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }
 
}
