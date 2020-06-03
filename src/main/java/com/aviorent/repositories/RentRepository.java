package com.aviorent.repositories;

import com.aviorent.models.Client;
import com.aviorent.models.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentRepository extends JpaRepository<Rent, Long> {
    List<Rent> findByClient(Client client);

}
