package com.aviorent.services;

import com.aviorent.models.Pilot;
import com.aviorent.repositories.PilotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PilotServiceImpl implements PilotRepository, PilotService {

    @Autowired
    private PilotRepository pilotRepository;

    @Override
    public List<Pilot> findAll() {
        return null;
    }

    @Override
    public List<Pilot> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Pilot> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Pilot> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Pilot pilot) {

    }

    @Override
    public void deleteAll(Iterable<? extends Pilot> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Pilot> S save(S s) {
        return null;
    }

    @Override
    public <S extends Pilot> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Pilot> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Pilot> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Pilot> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Pilot getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends Pilot> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Pilot> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Pilot> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Pilot> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Pilot> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Pilot> boolean exists(Example<S> example) {
        return false;
    }
}
