package com.aviorent.repositories;

import com.aviorent.models.Client;
import com.aviorent.models.Plane;
import com.aviorent.models.Rent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentRepository extends JpaRepository<Rent, Long> {
    List<Rent> findByClient(Client client);
    Rent getByPlane(Plane plane);
    Page<Rent> findAll(Pageable pageable);
    List<Rent> getAllByPlane(Plane plane);
}
