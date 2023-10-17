package com.ensah.bo;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Profil {
    @Id
    private final int  idP=1;
    @javax.validation.constraints.NotBlank(message="this field is required")
    private String lastName;
    @javax.validation.constraints.NotBlank(message="this field is required")
    private String firstName;
    @javax.validation.constraints.NotBlank(message="this field is required ")

    @Pattern(regexp = "^[0]{1}[6,7]{1}[0-9]{8}", message = "The persunel number must be '06'or '07' followed by 8 digits")

    private String perNum;
    @javax.validation.constraints.NotBlank(message="this field is required ")
    @Pattern(regexp = "^[0]{1}[6,7]{1}[0-9]{8}", message = "The persunel number must be '06'or '07' followed by 8 digits")

    private String proNum;
    @javax.validation.constraints.NotBlank(message="this field is required ")
    private String adresse ;
    @Email(message="enter a valid email ")
    @javax.validation.constraints.NotBlank(message="this field is required")
    private String perEmail;
    @Email(message="enter a valid email ")
    @javax.validation.constraints.NotBlank(message="this field is required")
    private String proEmail;

    @NotBlank(message = "This field is required")
    private String gender;

    public Profil() {
    }


    public long getIdProfil() {
        return idP;
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
