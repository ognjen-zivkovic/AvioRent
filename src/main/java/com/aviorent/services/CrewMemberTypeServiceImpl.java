package com.aviorent.services;

import com.aviorent.repositories.CrewMemberTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrewMemberTypeServiceImpl implements CrewMemberTypeService{

    @Autowired

    private CrewMemberTypeRepository crewMemberTypeRepository;
}
