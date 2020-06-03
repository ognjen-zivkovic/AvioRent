package com.aviorent.services;

import com.aviorent.models.Plane;
import com.aviorent.models.RentStatus;
import com.aviorent.repositories.RentStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentStatusImpl implements RentStatusService {

    @Autowired
    private RentStatusRepository rentStatusRepository;

    @Override
    public List<RentStatus> getAll() {
        return this.rentStatusRepository.findAll();
    }

    @Override
    public RentStatus save(RentStatus rentStatus) {
        RentStatus persistedRentStatus = this.rentStatusRepository.save(rentStatus);
        return persistedRentStatus;
    }

    @Override
    public Optional<RentStatus> getById(long id) {
        return this.rentStatusRepository.findById(id);
    }

    @Override
    public void deleteById(long id) {
        this.rentStatusRepository.deleteById(id);
    }

    @Override
    public RentStatus update(RentStatus rentStatus) {
        RentStatus persistedRentSatus = this.rentStatusRepository.save(rentStatus);
        return persistedRentSatus;
    }

}
