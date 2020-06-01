package com.aviorent.services;

import com.aviorent.models.Rent;
import com.aviorent.repositories.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentServiceImpl implements RentService {

    @Autowired
    private RentRepository rentRepository;


    @Override
    public List<Rent> getAll() {
        return rentRepository.findAll();
    }
}
