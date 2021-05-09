package com.cgi.dentistapp.service.interfaces;

import com.cgi.dentistapp.entity.DentistEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DentistService {

    List<DentistEntity> getAllDentists();

    long findDentistIDbyName();
}
