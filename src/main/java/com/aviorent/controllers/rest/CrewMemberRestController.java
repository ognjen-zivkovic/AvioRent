package com.aviorent.controllers.rest;

import com.aviorent.models.CrewMember;
import com.aviorent.services.CrewMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CrewMemberRestController {

    @Autowired
    private CrewMemberService crewMemberService;

    @GetMapping("/crewMemberRest")
    public ResponseEntity<List<CrewMember>> getCrewMembers ()
    {
        return new ResponseEntity<>(this.crewMemberService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/crewMemberRest")
    public  ResponseEntity<CrewMember> save(@RequestBody CrewMember crewMember)
    {
        return new ResponseEntity<>(crewMemberService.save(crewMember),HttpStatus.CREATED);
    }

    @GetMapping("/crewMemberRest/{id}")
    public ResponseEntity<CrewMember> getCrewMemberById(@PathVariable Long id)
    {
        Optional<CrewMember> crewMember = this.crewMemberService.getById(id);
        return crewMember.map(value -> new ResponseEntity<>(value,HttpStatus.OK)).orElseGet(()->new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @DeleteMapping("/crewMemberRest/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id)
    {
        Optional<CrewMember> crewMember = this.crewMemberService.getById(id);
        if(crewMember.isPresent())
        {
            this.crewMemberService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PutMapping("/crewMemberRest/{id}")
    public ResponseEntity<CrewMember> update(@RequestBody CrewMember crewMember,@PathVariable Long id)
    {
        Optional<CrewMember> existingCrewMember = this.crewMemberService.getById(id);

        if(existingCrewMember.isPresent())
        {
            CrewMember newCrewMember = existingCrewMember.get();
            newCrewMember.setFirstName(crewMember.getFirstName());
            newCrewMember.setLastName(crewMember.getLastName());
            return new ResponseEntity<>(this.crewMemberService.update(newCrewMember),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}


