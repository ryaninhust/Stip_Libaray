/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.stip.library.Restmodel;

/**
 *
 * @author ryanhust
 */
public class Book_Library_Simple {
    public String bookName;
    public Integer bookId;
    public Integer libraryId;
    public String  libraryName;
    public Integer schoolId;
    public String schoolName;
    public String schoolPhone;

    public Book_Library_Simple(String bookName, Integer bookId, Integer libraryId, String libraryName, Integer schoolId, String schoolName, String schoolPhone) {
        this.bookName = bookName;
        this.bookId = bookId;
        this.libraryId = libraryId;
        this.libraryName = libraryName;
        this.schoolId = schoolId;
        this.schoolName = schoolName;
        this.schoolPhone = schoolPhone;
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

    public String getSchoolPhone() {
        return schoolPhone;
    }

    public void setSchoolPhone(String schoolPhone) {
        this.schoolPhone = schoolPhone;
    }
    
    
}
