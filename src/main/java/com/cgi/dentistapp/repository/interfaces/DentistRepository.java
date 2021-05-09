package com.cgi.dentistapp.repository.interfaces;

import com.cgi.dentistapp.entity.DentistEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DentistRepository extends CrudRepository<DentistEntity, Long> {

    DentistEntity findByFirstNameAndLastName(String firstName, String lastName);
}
