package com.aviorent.services;

import com.aviorent.models.CrewMember;
import com.aviorent.models.Plane;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CrewMemberService {
    List<CrewMember> getAll();

    Optional<CrewMember> getById(long id);

    CrewMember save(CrewMember crewMember);

    void deleteById(long id);

    CrewMember update(CrewMember newCrewMember);

    Page<CrewMember> getPaginatedCrewMembers(Pageable pageable);


}
