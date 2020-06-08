package com.aviorent.repositories;

import com.aviorent.models.Plane;
import com.aviorent.models.PlaneImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaneRepository extends JpaRepository<Plane,Long> {

}
