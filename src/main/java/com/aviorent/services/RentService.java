package com.aviorent.services;

import com.aviorent.models.Client;
import com.aviorent.models.Rent;

import java.util.List;
import java.util.Optional;

public interface RentService {
    List<Rent> getAll();
    Rent create(Rent rent);
    Optional<Rent> getById(long id);
    void deleteById(long id);
    Rent update(Rent rent);
    void approveById(long id);
}
