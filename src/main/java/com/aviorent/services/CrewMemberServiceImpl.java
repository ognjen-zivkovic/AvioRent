package com.aviorent.services;

import com.aviorent.models.CrewMember;
import com.aviorent.models.CrewMemberType;
import com.aviorent.models.Plane;
import com.aviorent.repositories.CrewMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CrewMemberServiceImpl implements CrewMemberService {

    @Autowired
    private CrewMemberRepository crewMemberRepository;

    @Override
    public List<CrewMember> getAll() {
        return this.crewMemberRepository.findAll();
    }

    @Override
    public Optional<CrewMember> getById(long id) {
        return this.crewMemberRepository.findById(id);
    }

    @Override
    public CrewMember save(CrewMember crewMember) {
        CrewMember persistedCrewMember = this.crewMemberRepository.save(crewMember);
        return persistedCrewMember;
    }

    @Override
    public void deleteById(long id) {
        this.crewMemberRepository.deleteById(id);
    }

    @Override
    public CrewMember update(CrewMember crewMember) {
        CrewMember persistedCrewMember = this.crewMemberRepository.save(crewMember);
        return persistedCrewMember;
    }

    @Override
    //@Cacheable("crewMembers")
    public Page<CrewMember> getPaginatedCrewMembers(Pageable pageable) {
        //simulateSlowService();
        return this.crewMemberRepository.findAll(pageable);
    }

     /*private void simulateSlowService() {
        try {
            long time = 5000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }*/
}
