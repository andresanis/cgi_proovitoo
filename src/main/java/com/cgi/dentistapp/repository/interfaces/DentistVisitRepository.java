package com.cgi.dentistapp.repository.interfaces;

import com.cgi.dentistapp.entity.DentistVisitEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface DentistVisitRepository extends CrudRepository<DentistVisitEntity, Long> {

}
