package com.cgi.dentistapp.service.interfaces;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public interface DentistVisitService {


    void addVisit(String dentistName, Date visitTime);
}
