package com.aviorent.services;

import com.aviorent.models.Client;
import com.aviorent.models.Plane;
import com.aviorent.models.Rent;
import com.aviorent.models.RentStatus;
import com.aviorent.repositories.RentRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

        Optional<Client> client = clientService.getByUsername(rent.getClient().getUserName());
        client.ifPresent(c -> rent.setClient(c));

        Optional<Plane> plane = planeService.getById(rent.getPlane().getPlaneId());
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

    @Override
    public Rent getByPlane(Plane plane) {
        return this.rentRepository.getByPlane(plane);
    }

    @Override
    @Cacheable("rents")
    public Page<Rent> getPaginatedRents(Pageable pageable) {
//        simulateSlowService();
        return this.rentRepository.findAll(pageable);
    }

    @Override
    public List<Rent> getAllByUserName(String username) {
        Optional<Client> user = clientService.getByUsername(username);

        return rentRepository.findByClient(user.get());
    }

    @Override
    public List<Rent> getAllByPlane(Plane plane) {
        return this.rentRepository.getAllByPlane(plane);
    }

//    private void simulateSlowService() {
//        try {
//            long time = 5000L;
//            Thread.sleep(time);
//        } catch (InterruptedException e) {
//            throw new IllegalStateException(e);
//        }
//    }

}
