package com.cgi.dentistapp.service;

import com.cgi.dentistapp.entity.DentistEntity;
import com.cgi.dentistapp.repository.interfaces.DentistRepository;
import com.cgi.dentistapp.service.interfaces.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DentistService_impl implements DentistService {

    @Autowired
    DentistRepository dentistRepository;

    @Override
    public List<DentistEntity> getAllDentists() {

        return (List<DentistEntity>) dentistRepository.findAll();
    }

    @Override
    public long findDentistIDbyName() {
        return 0;
    }
}
