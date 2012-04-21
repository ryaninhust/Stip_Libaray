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
public class Book_Library {
  public    String stipBookInfo;
  public    List<Library_Amount_School> library_Amount_Schools;

    public List<Library_Amount_School> getLibrary_Amount_Schools() {
        return library_Amount_Schools;
    }

    public void setLibrary_Amount_Schools(List<Library_Amount_School> library_Amount_Schools) {
        this.library_Amount_Schools = library_Amount_Schools;
    }

    public String getStipBookInfo() {
        return stipBookInfo;
    }

    public void setStipBookInfo(String stipBookInfo) {
        this.stipBookInfo = stipBookInfo;
    }

    public Book_Library(String stipBookInfo, List<Library_Amount_School> library_Amount_Schools) {
        this.stipBookInfo = stipBookInfo;
        this.library_Amount_Schools = library_Amount_Schools;
    }
    
    
        
}
