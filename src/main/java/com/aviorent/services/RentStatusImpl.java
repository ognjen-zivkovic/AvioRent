package com.aviorent.services;

import com.aviorent.models.RentStatus;
import com.aviorent.repositories.RentStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentStatusImpl implements RentStatusService {

    @Autowired
    private RentStatusRepository rentStatusRepository;

    @Override
    public List<RentStatus> getAll() {
        return this.rentStatusRepository.findAll();
    }

}
