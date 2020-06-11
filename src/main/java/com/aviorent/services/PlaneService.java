package com.aviorent.services;

import com.aviorent.models.Plane;
import com.aviorent.models.PlaneImage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface PlaneService {
    List<Plane> getAll();
    Plane save(Plane plane);
    Optional<Plane> getById(long id);
    void deleteById(long id);
    Plane update(Plane plane);
    Page<Plane> getPaginatedPlanes(Pageable pageable);
}
