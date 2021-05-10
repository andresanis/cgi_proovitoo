package com.cgi.dentistapp.repository.interfaces;

import com.cgi.dentistapp.entity.DentistVisitEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DentistVisitRepository extends CrudRepository<DentistVisitEntity, Long> {

    DentistVisitEntity findByDentistNameAndVisitDateAndVisitTime(String dentistName, Date visitDate, String visitTime);

    @Query(value="select * from dentist_visit e where e.dentistname like %:keyword% or e.visittime like %:keyword% or e.visitdate like %:keyword%", nativeQuery = true)
    List<DentistVisitEntity> findDentistVisitEntitiesByKeyword(@Param("keyword") String keyword);

}
