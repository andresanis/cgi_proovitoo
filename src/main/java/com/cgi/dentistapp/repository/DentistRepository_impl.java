package com.cgi.dentistapp.repository;

import com.cgi.dentistapp.entity.DentistEntity;
import com.cgi.dentistapp.repository.interfaces.DentistRepository;
import org.springframework.stereotype.Repository;


@Repository
public class DentistRepository_impl implements DentistRepository {

    @Override
    public <S extends DentistEntity> S save(S s) {
        return null;
    }

    @Override
    public <S extends DentistEntity> Iterable<S> save(Iterable<S> iterable) {
        return null;
    }

    @Override
    public DentistEntity findOne(Long id) {
        return null;
    }

    @Override
    public boolean exists(Long id) {
        return false;
    }

    @Override
    public Iterable<DentistEntity> findAll() {
        return null;
    }

    @Override
    public Iterable<DentistEntity> findAll(Iterable<Long> iterable) {
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
    public void delete(DentistEntity dentistEntity) {

    }

    @Override
    public void delete(Iterable<? extends DentistEntity> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public DentistEntity findByFirstNameAndLastName(String firstName, String lastName) {
        return null;
    }
}
