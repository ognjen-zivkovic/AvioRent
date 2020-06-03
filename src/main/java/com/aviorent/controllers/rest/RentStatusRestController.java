package com.aviorent.controllers.rest;

import com.aviorent.models.RentStatus;
import com.aviorent.services.RentStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public  class  RentStatusRestController{

    @Autowired
    private RentStatusService rentStatusService;

    @GetMapping("/rentStatusRest")
    public ResponseEntity<List<RentStatus>>getRentStatus()
    {
        return new ResponseEntity<>(this.rentStatusService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/rentStatusRest")
    public  ResponseEntity<RentStatus> save(@RequestBody   RentStatus rentStatus)
    {
        return new ResponseEntity<>(rentStatusService.save(rentStatus),  HttpStatus.CREATED);
    }

    @GetMapping ("/rentStatusRest/{id}")
    public  ResponseEntity<RentStatus> getRentStatusById(@PathVariable Long  id)
    {
        Optional<RentStatus> rentStatus=this.rentStatusService.getById(id);
        return rentStatus.map(value-> new ResponseEntity<>(value,HttpStatus.OK)).orElseGet(()->new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @DeleteMapping ("/rentStatusRest/{id}")
    public  ResponseEntity<HttpStatus> delete(@PathVariable Long id)
    {
        Optional<RentStatus>  rentStatus=this.rentStatusService.getById(id);
        if (rentStatus.isPresent())
        {
            this.rentStatusService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/rentStatusRest/{id}")
    public ResponseEntity<RentStatus> update(@RequestBody RentStatus rentStatus, @PathVariable  Long id)
    {
        Optional<RentStatus> exsistingRentStatus = this.rentStatusService. getById(id);
        if (exsistingRentStatus.isPresent())
            {
                RentStatus newRentStatus=exsistingRentStatus.get();
                newRentStatus.setStatus(rentStatus.getStatus());
            }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}