package com.aviorent.services;

import com.aviorent.models.Plane;
import com.aviorent.models.RentStatus;

import java.util.List;
import java.util.Optional;

public interface RentStatusService {
    public List<RentStatus> getAll();
    RentStatus save(RentStatus rentStatus);
    Optional<RentStatus> getById(long id);
    void deleteById(long id);
    RentStatus update(RentStatus rentStatus);
}
