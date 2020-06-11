package com.aviorent.repositories;


import com.aviorent.models.Plane;
import com.aviorent.models.PlaneImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaneImageRepository extends JpaRepository<PlaneImage, Long> {
    List<PlaneImage> getAllByPlane(Plane plane);
    void deleteByPlaneImageId(long id);
    PlaneImage getByPlaneImageId(long id);
}
