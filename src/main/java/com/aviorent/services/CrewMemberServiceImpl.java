package com.aviorent.services;

import com.aviorent.models.CrewMember;
import com.aviorent.models.CrewMemberType;
import com.aviorent.repositories.CrewMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrewMemberServiceImpl implements CrewMemberService {

    @Autowired
    private CrewMemberRepository crewMemberRepository;

    @Override
    public List<CrewMember> getAll() {
        return this.crewMemberRepository.findAll();
    }
}
