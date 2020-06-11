package com.aviorent.controllers.rest;

import ch.qos.logback.core.boolex.EvaluationException;
import com.aviorent.models.Plane;
import com.aviorent.services.PlaneService;
import javafx.print.PageLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
public class PlaneRestController {

    @Autowired
    private PlaneService planeService;

    @GetMapping("/planeRest")
    public ResponseEntity<List<Plane>> getPlanes ()
    {
        return new ResponseEntity<>(this.planeService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/planesRest")
    public  ResponseEntity<Plane> save(@RequestBody Plane plane)
    {
      return new ResponseEntity<>(planeService.save(plane),HttpStatus.CREATED);
    }

    @GetMapping("/planeRest/{id}")
    public ResponseEntity<Plane> getPlaneById(@PathVariable Long id)
    {
        Optional<Plane> plane = this.planeService.getById(id);
        return plane.map(value -> new ResponseEntity<>(value,HttpStatus.OK)).orElseGet(()->new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @DeleteMapping("/planeRest/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id)
    {
        Optional<Plane> plane = this.planeService.getById(id);
        if(plane.isPresent())
        {
            this.planeService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/planeRest/{id}")
    public ResponseEntity<Plane> update(@RequestBody Plane plane,@PathVariable Long id)
    {
        Optional<Plane> existingPlane = this.planeService.getById(id);

        if(existingPlane.isPresent())
        {
            Plane newPlane = existingPlane.get();
            newPlane.setModel(plane.getModel());

            newPlane.setMaxSpeed(plane.getMaxSpeed());
            newPlane.setPrice(plane.getPrice());
            newPlane.setRange(plane.getRange());
            newPlane.setSeats(plane.getSeats());
            return new ResponseEntity<>(this.planeService.update(newPlane),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
