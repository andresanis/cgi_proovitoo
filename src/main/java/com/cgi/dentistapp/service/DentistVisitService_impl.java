package com.cgi.dentistapp.service;

import com.cgi.dentistapp.entity.DentistVisitEntity;
import com.cgi.dentistapp.repository.interfaces.DentistRepository;
import com.cgi.dentistapp.repository.interfaces.DentistVisitRepository;
import com.cgi.dentistapp.service.interfaces.DentistVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class DentistVisitService_impl implements DentistVisitService {

    @Autowired
    DentistVisitRepository dentistVisitRepository;

    @Autowired
    DentistRepository dentistRepository;

    @Override
    public void addVisit(String dentistName, Date visitTime) {
        DentistVisitEntity dentistVisitEntity = new DentistVisitEntity();
        String[] arrOfStr = dentistName.split(" ");
        dentistVisitEntity.setDentistId(dentistRepository.findByFirstNameAndLastName(arrOfStr[0], arrOfStr[1]).getDentistId());
        dentistVisitEntity.setDentistName(dentistName);
        dentistVisitEntity.setVisitTime(visitTime);
        dentistVisitRepository.save(dentistVisitEntity);
    }
}
