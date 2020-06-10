package com.aviorent.services;

import com.aviorent.models.Client;
import com.aviorent.models.Plane;
import com.aviorent.models.Rent;
import com.aviorent.models.RentStatus;
import com.aviorent.repositories.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RentServiceImpl implements RentService {

    @Autowired
    private RentRepository rentRepository;

    @Autowired
    private RentStatusService rentStatusService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private PlaneService planeService;

    @Override
    public List<Rent> getAll() {
        return rentRepository.findAll();
    }

    @Override
    public Rent create(Rent rent) {
        // TODO: change client and plane from static to dynamic
        Optional<RentStatus> rentStatus = rentStatusService.getById(502);
        rentStatus.ifPresent(rs -> rent.setRentStatus(rs));

        Optional<Client> client = clientService.getById(501);
        client.ifPresent(c -> rent.setClient(c));

        Optional<Plane> plane = planeService.getById(501);
        plane.ifPresent(p -> rent.setPlane(p));

        rent.setCreatedAt(new Date());

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

    @Override
    public void approveById(long id) {
        Optional<Rent> rent = getById(id);
        Optional<RentStatus> rentStatus = rentStatusService.getById(503);

        rentStatus.ifPresent(rs -> rent.ifPresent(r -> r.setRentStatus(rs)));
        rent.ifPresent(r -> rentRepository.save(r));
    }

}
