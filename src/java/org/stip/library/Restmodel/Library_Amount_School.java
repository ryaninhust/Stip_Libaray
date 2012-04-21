/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.stip.library.Restmodel;

/**
 *
 * @author ryanhust
 */
public class Library_Amount_School {
    public String libraryName;
    public  Integer bookAmount;
    public String schoolName;

    public Integer getBookAmount() {
        return bookAmount;
    }

    public void setBookAmount(Integer bookAmount) {
        this.bookAmount = bookAmount;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Library_Amount_School(String libraryName, Integer bookAmount, String schoolName) {
        this.libraryName = libraryName;
        this.bookAmount = bookAmount;
        this.schoolName = schoolName;
    }
    
}
