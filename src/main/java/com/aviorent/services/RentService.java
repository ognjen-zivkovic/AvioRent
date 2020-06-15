package com.aviorent.services;

import com.aviorent.models.Client;
import com.aviorent.models.Plane;
import com.aviorent.models.Rent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface RentService {
    List<Rent> getAll();
    Rent create(Rent rent);
    Optional<Rent> getById(long id);
    void deleteById(long id);
    Rent update(Rent rent);
    void approveById(long id);
    Rent getByPlane(Plane plane);
    Page<Rent> getPaginatedRents(Pageable pageable);
    List<Rent> getAllByUserName(String username);
    List<Rent> getAllByPlane(Plane plane);
}
