package com.colleage.nit.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullNameEnglish;
    private String fullNameArabic;
    private String emailAddress;
    private String telephoneNumber;
    private String address;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Course courses;
    public Course getCourses() {
        return courses;
    }

    public void setCourses(Course courses) {
        this.courses = courses;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullNameEnglish() {
        return fullNameEnglish;
    }

    public void setFullNameEnglish(String fullNameEnglish) {
        this.fullNameEnglish = fullNameEnglish;
    }

    public String getFullNameArabic() {
        return fullNameArabic;
    }

    public void setFullNameArabic(String fullNameArabic) {
        this.fullNameArabic = fullNameArabic;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
