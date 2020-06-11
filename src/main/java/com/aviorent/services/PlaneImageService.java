package com.aviorent.services;


import com.aviorent.models.Plane;
import com.aviorent.models.PlaneImage;

import java.util.List;

public interface PlaneImageService {
    PlaneImage Save(PlaneImage planeImage);
    List<PlaneImage> getAllByPlane(Plane plane);
    void deleteByPlaneImageId(long id);
    PlaneImage getByPlaneImageId(long id);

}
