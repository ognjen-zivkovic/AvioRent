package com.aviorent.services;

import com.aviorent.models.Client;
import com.aviorent.models.Rent;
import com.aviorent.repositories.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentServiceImpl implements RentService {

    @Autowired
    private RentRepository rentRepository;


    @Override
    public List<Rent> getAll() {
        return rentRepository.findAll();
    }

    @Override
    public Rent create(Rent rent) {
        Rent persistedRent = rentRepository.save(rent);

        return persistedRent;
    }

    @Override
    public Optional<Rent> getById(long id) {
        return rentRepository.findById(id);
    }

    @Override
    public void deleteById(long id) {
        rentRepository.deleteById(id);
    }

    @Override
    public Rent update(Rent rent) {
        Rent persistedRent = rentRepository.save(rent);

        return persistedRent;
    }
    public List<Rent> primer(Client client)
    {
     return this.rentRepository.findByClient(client);
    }

}
