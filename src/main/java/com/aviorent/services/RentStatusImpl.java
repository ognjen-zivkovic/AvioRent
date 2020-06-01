package com.aviorent.services;

import com.aviorent.repositories.RentStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentStatusImpl implements RentStatusService {

    @Autowired
    private RentStatusRepository rentStatusRepository;
}
