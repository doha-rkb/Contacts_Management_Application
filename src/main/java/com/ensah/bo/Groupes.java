package com.ensah.bo;



import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;



@Entity
public class Groupes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGroup;
//    @NotBlank(message="this field is required ")
    private String gname;
    @ManyToMany(cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH},mappedBy = "groupes")
    private Set<Contact> contacts=new HashSet<Contact>();

    public Long getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(Long idGroup) {
        this.idGroup = idGroup;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        contacts = contacts;
    }

    @Override
    public String toString() {
        return "Groupes{" +
                "idGroup=" + idGroup +
                ", gname='" + gname + '\'' +
                ", Contacts=" + contacts +
                '}';
    }

    public Groupes(String gname) {
        this.gname = gname;

    }
    public Groupes(){

    }
}
