package com.cgi.dentistapp.service.interfaces;

import com.cgi.dentistapp.entity.DentistEntity;
import com.cgi.dentistapp.entity.DentistVisitEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface DentistVisitService {


    void addVisit(String dentistName, Date visitDate, String visitTime);

    List<DentistVisitEntity> getAllVisits();

    DentistVisitEntity getVisitByID(long id);

    DentistVisitEntity getVisitByNameAndDateAndTime(String dentistName, Date visitDate, String visitTime);

    void deleteVisit(DentistVisitEntity dentistVisitEntity);

    void updateVisit(long id, String dentistName, Date visitDate, String visitTime );
}
