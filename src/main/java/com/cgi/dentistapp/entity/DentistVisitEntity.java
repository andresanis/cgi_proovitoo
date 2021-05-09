package com.cgi.dentistapp.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "dentist_visit")
public class DentistVisitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="DENTIST_ID", nullable = false)
    private long dentistId;
    @Column(name="DENTISTNAME", length=50, nullable = false)
    private String dentistName;
    @Column(name = "VISITTIME", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date visitTime;


    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public String getDentistName() {
        return dentistName;
    }

    public void setDentistName(String dentistName) {
        this.dentistName = dentistName;
    }

    public Long getId() {
        return id;
    }

    public void setDentistId(long dentistId) {
        this.dentistId = dentistId;
    }
}
