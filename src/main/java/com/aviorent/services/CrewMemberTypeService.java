package com.aviorent.services;

import com.aviorent.models.CrewMemberType;
import com.aviorent.models.Plane;

import java.util.List;
import java.util.Optional;

public interface CrewMemberTypeService {
    List<CrewMemberType> getAll();
    CrewMemberType save(CrewMemberType crewMemberType);
    Optional<CrewMemberType> getById(long id);
    void deleteById(long id);
    CrewMemberType update(CrewMemberType crewMemberType);
}
