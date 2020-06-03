package com.aviorent.controllers.rest;

import com.aviorent.models.CrewMemberType;
import com.aviorent.models.Plane;
import com.aviorent.services.CrewMemberTypeService;
import com.aviorent.services.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CrewMemberTypeRestController {


    @Autowired
    //private PlaneService planeService;
    private CrewMemberTypeService crewMemberTypeService;

    @GetMapping("/crewMemberTypeRest")
    public ResponseEntity<List<CrewMemberType>> getCrewMemberTypes ()
    {
        return new ResponseEntity<>(this.crewMemberTypeService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/crewMemberTypesRest")
    public  ResponseEntity<CrewMemberType> save(@RequestBody CrewMemberType crewMemberType)
    {
        return new ResponseEntity<>(this.crewMemberTypeService.save(crewMemberType),HttpStatus.CREATED);
    }

    @GetMapping("/crewMemberTypeRest/{id}")
    public ResponseEntity<CrewMemberType> getCrewMemberById(@PathVariable Long id)
    {
        Optional<CrewMemberType> crewMemberType = this.crewMemberTypeService.getById(id);
        return crewMemberType.map(value -> new ResponseEntity<>(value,HttpStatus.OK)).orElseGet(()->new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/crewMemberTypeRest/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id)
    {
        Optional<CrewMemberType> crewMemberType = this.crewMemberTypeService.getById(id);
        if(crewMemberType.isPresent())
        {
            this.crewMemberTypeService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/crewMemberTypeRest/{id}")
    public ResponseEntity<CrewMemberType> update(@RequestBody CrewMemberType crewMemberType,@PathVariable Long id)
    {
        Optional<CrewMemberType> existingCrewMemberType = this.crewMemberTypeService.getById(id);

        if(existingCrewMemberType.isPresent())
        {
            CrewMemberType newCrewMemberType = existingCrewMemberType.get();
            newCrewMemberType.setType(crewMemberType.getType());
            return new ResponseEntity<>(this.crewMemberTypeService.update(newCrewMemberType),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
