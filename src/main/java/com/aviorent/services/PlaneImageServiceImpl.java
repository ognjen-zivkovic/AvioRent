package com.aviorent.services;


import com.aviorent.models.Plane;
import com.aviorent.models.PlaneImage;
import com.aviorent.repositories.PlaneImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaneImageServiceImpl implements PlaneImageService {

    @Autowired
    private PlaneImageRepository planeImageRepository;

    @Override
    public PlaneImage Save(PlaneImage planeImage) {
        PlaneImage persisted = this.planeImageRepository.save(planeImage);
        return persisted;
    }

    @Override
    public List<PlaneImage> getAllByPlane(Plane plane) {
        return planeImageRepository.getAllByPlane(plane);
    }

    @Override
    public void deleteByPlaneImageId(long id) {
        this.planeImageRepository.deleteByPlaneImageId(id);
    }

    @Override
    public PlaneImage getByPlaneImageId(long id) {
        return this.planeImageRepository.getByPlaneImageId(id);
    }


}
