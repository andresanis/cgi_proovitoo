package com.cgi.dentistapp.entity;


import javax.persistence.*;

@Entity
@Table(name = "dentists")
public class DentistEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long dentistId;
    @Column(name="FIRSTNAME", length = 15, nullable = false)
    private String firstName;
    @Column(name="LASTNAME", length = 35, nullable = false)
    private String lastName;

    public Long getDentistId() {
        return dentistId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

}
