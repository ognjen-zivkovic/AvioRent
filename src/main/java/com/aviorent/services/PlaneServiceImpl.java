package com.aviorent.services;


import com.aviorent.models.Plane;
import com.aviorent.models.PlaneImage;
import com.aviorent.repositories.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaneServiceImpl implements PlaneService {
    @Autowired
    private PlaneRepository planeRepository;

    @Override
    public List<Plane> getAll() {
        return this.planeRepository.findAll();
    }

    @Override
    public Plane save(Plane plane) {
        Plane persistedPlane = this.planeRepository.save(plane);
        return persistedPlane;
    }

    @Override
    public Optional<Plane> getById(long id) {
        return this.planeRepository.findById(id);
    }

    @Override
    public void deleteById(long id) {
        this.planeRepository.deleteById(id);
    }

    @Override
    public Plane update(Plane plane) {
        Plane persistedPlane = this.planeRepository.save(plane);
        return persistedPlane;
    }

    @Override
    //@Cacheable("planes")
    public Page<Plane> getPaginatedPlanes(Pageable pageable) {
        //simulateSlowService();
        return this.planeRepository.findAll(pageable);
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
