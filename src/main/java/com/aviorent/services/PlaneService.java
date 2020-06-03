package com.aviorent.services;

import com.aviorent.models.Plane;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface PlaneService {
    List<Plane> getAll();
    Plane save(Plane plane);
    Optional<Plane> getById(long id);
    void deleteById(long id);
    Plane update(Plane plane);
}
