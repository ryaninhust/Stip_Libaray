package org.stip.library.Model;
// Generated 2011-12-27 19:50:28 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * StipSchool generated by hbm2java
 */
@Entity
@Table(name="stip_school"
    ,catalog="library"
)
public class StipSchool  implements java.io.Serializable {


     private Integer id;
     private String name;
     private String phone;
     private Set<StipLibrary> stipLibraries = new HashSet<StipLibrary>(0);

    public StipSchool() {
    }

    public StipSchool(String name, String phone, Set<StipLibrary> stipLibraries) {
       this.name = name;
       this.phone = phone;
       this.stipLibraries = stipLibraries;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    @Column(name="name", length=15)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="phone", length=15)
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="stipSchool")
    public Set<StipLibrary> getStipLibraries() {
        return this.stipLibraries;
    }
    
    public void setStipLibraries(Set<StipLibrary> stipLibraries) {
        this.stipLibraries = stipLibraries;
    }




}

