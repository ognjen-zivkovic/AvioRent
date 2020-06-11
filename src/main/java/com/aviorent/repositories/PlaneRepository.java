package com.aviorent.repositories;

import com.aviorent.models.Plane;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaneRepository extends JpaRepository<Plane,Long> {
    Page<Plane> findAll(Pageable pageable);

}
