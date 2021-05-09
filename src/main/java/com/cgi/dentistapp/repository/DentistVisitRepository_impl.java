package com.cgi.dentistapp.repository;

import com.cgi.dentistapp.entity.DentistVisitEntity;
import com.cgi.dentistapp.repository.interfaces.DentistVisitRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class DentistVisitRepository_impl implements DentistVisitRepository {
    @Override
    public <S extends DentistVisitEntity> S save(S s) {
        return null;
    }

    @Override
    public <S extends DentistVisitEntity> Iterable<S> save(Iterable<S> iterable) {
        return null;
    }

    @Override
    public DentistVisitEntity findOne(Long aLong) {
        return null;
    }

    @Override
    public boolean exists(Long aLong) {
        return false;
    }

    @Override
    public Iterable<DentistVisitEntity> findAll() {
        return null;
    }

    @Override
    public Iterable<DentistVisitEntity> findAll(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public void delete(DentistVisitEntity dentistVisitEntity) {

    }

    @Override
    public void delete(Iterable<? extends DentistVisitEntity> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
