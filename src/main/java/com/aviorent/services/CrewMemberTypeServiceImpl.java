package com.aviorent.services;

import com.aviorent.models.CrewMemberType;
import com.aviorent.models.Plane;
import com.aviorent.repositories.CrewMemberTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CrewMemberTypeServiceImpl implements CrewMemberTypeService{

    @Autowired
    private CrewMemberTypeRepository crewMemberTypeRepository;


    @Override
    public List<CrewMemberType> getAll() {
      return this.crewMemberTypeRepository.findAll();
    }


    @Override
    public CrewMemberType save(CrewMemberType crewMemberType) {
        CrewMemberType persistedCrewMemberType = this.crewMemberTypeRepository.save(crewMemberType);
        return persistedCrewMemberType;
    }

    @Override
    public Optional<CrewMemberType> getById(long id) {
        return this.crewMemberTypeRepository.findById(id);
    }

    @Override
    public void deleteById(long id) {
        this.crewMemberTypeRepository.deleteById(id);
    }

    @Override
    public CrewMemberType update(CrewMemberType crewMemberType) {
        CrewMemberType persistedCrewMemberType = this.crewMemberTypeRepository.save(crewMemberType);
        return persistedCrewMemberType;
    }

}
