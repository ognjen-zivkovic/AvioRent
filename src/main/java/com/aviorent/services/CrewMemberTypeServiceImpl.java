package com.aviorent.services;

import com.aviorent.models.CrewMemberType;
import com.aviorent.repositories.CrewMemberTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrewMemberTypeServiceImpl implements CrewMemberTypeService{

    @Autowired
    private CrewMemberTypeRepository crewMemberTypeRepository;


    @Override
    public List<CrewMemberType> getAll() {
      return this.crewMemberTypeRepository.findAll();
    }
}
