package com.aviorent.controllers.rest;

import com.aviorent.models.Client;
import com.aviorent.models.Plane;
import com.aviorent.models.Rent;
import com.aviorent.models.RentStatus;
import com.aviorent.repositories.RentStatusRepository;
import com.aviorent.services.ClientService;
import com.aviorent.services.PlaneService;
import com.aviorent.services.RentService;
import com.aviorent.services.RentStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RentRestController {

    @Autowired
    private RentService rentService;

    @Autowired
    private RentStatusService rentStatusService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private PlaneService planeService;

    @GetMapping("/rentsRest")
    ResponseEntity<List<Rent>> getRents() {
        return new ResponseEntity<>(this.rentService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/rentsRest/{id}")
    public ResponseEntity<Rent> getRent(@PathVariable long id)
    {
        Optional<Rent> rent = this.rentService.getById(id);
        return rent.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/rentsRest")
    public ResponseEntity<Rent> create(@RequestBody Rent rent) {
        Optional<RentStatus> rentStatus = rentStatusService.getById(502);
        rentStatus.ifPresent(rent::setRentStatus);

        Optional<Client> client = clientService.getById(rent.getClient().getClientId());
        client.ifPresent(rent::setClient);

        Optional<Plane> plane = planeService.getById(rent.getPlane().getPlaneId());
        plane.ifPresent(rent::setPlane);

        return new ResponseEntity<>(rentService.create(rent), HttpStatus.CREATED);
    }

    @PutMapping("/rentsRest/{id}")
    public ResponseEntity<Rent> update(@RequestBody Rent rent, @PathVariable Long id)
    {
        Optional<Rent> existingRent = this.rentService.getById(id);

        if(existingRent.isPresent())
        {
            Rent newRent = existingRent.get();
            newRent.setDateEnd(rent.getDateEnd());
            newRent.setCreatedAt(rent.getCreatedAt());
            newRent.setPassengers(rent.getPassengers());
            newRent.setDestinationFrom(rent.getDestinationFrom());
            newRent.setDestinationTo(rent.getDestinationTo());
            newRent.setRoundTrip(rent.isRoundTrip());

            Optional<RentStatus> rentStatus = rentStatusService.getById(rent.getRentStatus().getRentStatusId());
            rentStatus.ifPresent(newRent::setRentStatus);

            Optional<Client> client = clientService.getById(rent.getClient().getClientId());
            client.ifPresent(newRent::setClient);

            Optional<Plane> plane = planeService.getById(rent.getPlane().getPlaneId());
            plane.ifPresent(newRent::setPlane);

            // TODO: RentStatus rentStatus = rentStatusService.getRentStatusById()
            // newRent.setRentStatus(rentStatus);

            return new ResponseEntity<>(this.rentService.update(newRent), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/rentsRest/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id)
    {
        Optional<Rent> rent = this.rentService.getById(id);

        if(rent.isPresent())
        {
            this.rentService.deleteById(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
