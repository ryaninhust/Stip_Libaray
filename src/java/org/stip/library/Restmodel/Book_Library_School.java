/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.stip.library.Restmodel;

/**
 *
 * @author ryanhust
 */
public class Book_Library_School {
   public Integer bookId; 
   public String  bookName;
   public Integer libraryId;
   public String  libraryName;
   public Integer schoolId;
   public String  schoolName;

    public Book_Library_School(Integer bookId, String bookName, Integer libraryId, String libraryName, Integer schoolId, String schoolName) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.libraryId = libraryId;
        this.libraryName = libraryName;
        this.schoolId = schoolId;
        this.schoolName = schoolName;
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
