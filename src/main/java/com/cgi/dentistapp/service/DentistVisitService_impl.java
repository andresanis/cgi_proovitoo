package com.cgi.dentistapp.service;

import com.cgi.dentistapp.entity.DentistEntity;
import com.cgi.dentistapp.entity.DentistVisitEntity;
import com.cgi.dentistapp.repository.interfaces.DentistRepository;
import com.cgi.dentistapp.repository.interfaces.DentistVisitRepository;
import com.cgi.dentistapp.service.interfaces.DentistVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class DentistVisitService_impl implements DentistVisitService {

    @Autowired
    DentistVisitRepository dentistVisitRepository;

    @Autowired
    DentistRepository dentistRepository;

    @Override
    public void addVisit(String dentistName, Date visitDate, String visitTime) {
        DentistVisitEntity dentistVisitEntity = new DentistVisitEntity();
        String[] arrOfStr = dentistName.split(" ");
        dentistVisitEntity.setDentistId(dentistRepository.findByFirstNameAndLastName(arrOfStr[0], arrOfStr[1]).getDentistId());
        dentistVisitEntity.setDentistName(dentistName);
        dentistVisitEntity.setVisitDate(visitDate);
        dentistVisitEntity.setVisitTime(visitTime);
        dentistVisitRepository.save(dentistVisitEntity);
    }

    @Override
    public List<DentistVisitEntity> getAllVisits() {
        return (List<DentistVisitEntity>) dentistVisitRepository.findAll();
    }

    @Override
    public DentistVisitEntity getVisitByID(long id) {
        return dentistVisitRepository.findOne(id);
    }

    @Override
    public DentistVisitEntity getVisitByNameAndDateAndTime(String dentistName, Date visitDate, String visitTime) {
        return dentistVisitRepository.findByDentistNameAndVisitDateAndVisitTime(dentistName, visitDate, visitTime);
    }

    @Override
    public void deleteVisit(DentistVisitEntity dentistVisitEntity) {
        dentistVisitRepository.delete(dentistVisitEntity);
    }

    public void updateVisit(long id, String dentistName, Date visitDate, String visitTime) {
        DentistVisitEntity dentistVisitEntity = new DentistVisitEntity();
        String[] arrOfStr = dentistName.split(" ");
        dentistVisitEntity.setId(id);
        dentistVisitEntity.setDentistId(dentistRepository.findByFirstNameAndLastName(arrOfStr[0], arrOfStr[1]).getDentistId());
        dentistVisitEntity.setDentistName(dentistName);
        dentistVisitEntity.setVisitDate(visitDate);
        dentistVisitEntity.setVisitTime(visitTime);
        dentistVisitRepository.save(dentistVisitEntity);
    }
}
