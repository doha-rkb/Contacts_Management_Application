package com.ensah.bo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.*;



@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long idContact;
    @NotBlank(message="this field is required")
    private String lastName;
    @NotBlank(message="this field is required")
    private String firstName;
    @NotBlank(message="this field is required ")

    @Pattern(regexp = "^[0]{1}[6,7]{1}[0-9]{8}", message = "The persunel number must be '06'or '07' followed by 8 digits")

    private String perNum;
    @NotBlank(message="this field is required ")
    @Pattern(regexp = "^[0]{1}[6,7]{1}[0-9]{8}", message = "The persunel number must be '06'or '07' followed by 8 digits")

    private String proNum;
    @NotBlank(message="this field is required ")
    private String adresse ;
    @Email(message="enter a valid email ")
    @NotBlank(message="this field is required")
    private String perEmail;
    @Email(message="enter a valid email ")
    @NotBlank(message="this field is required")
    private String proEmail;

    @NotBlank(message = "This field is required")
    private String gender;
    @ManyToMany(cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinTable(name="GroupContact",joinColumns=@JoinColumn(name="idContact"),inverseJoinColumns = @JoinColumn(name="idGroup"))
    private Set<Groupes> groupes =new HashSet<Groupes>();

    public Contact() {
    }

    public Set<Groupes> getGroups() {
        return groupes;
    }

    public void setGroups(Set<Groupes> groupes) {
        this.groupes = groupes;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "idContact=" + idContact +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", perNum='" + perNum + '\'' +
                ", proNum='" + proNum + '\'' +
                ", adresse='" + adresse + '\'' +
                ", perEmail='" + perEmail + '\'' +
                ", proEmail='" + proEmail + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public long getIdContact() {
        return idContact;
    }

    public void setIdContact(long idContact) {
        this.idContact = idContact;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPerNum() {
        return perNum;
    }

    public void setPerNum(String perNum) {
        this.perNum = perNum;
    }

    public String getProNum() {
        return proNum;
    }

    public void setProNum(String proNum) {
        this.proNum = proNum;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPerEmail() {
        return perEmail;
    }

    public void setPerEmail(String perEmail) {
        this.perEmail = perEmail;
    }

    public String getProEmail() {
        return proEmail;
    }

    public void setProEmail(String proEmail) {
        this.proEmail = proEmail;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
