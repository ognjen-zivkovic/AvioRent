package com.aviorent.services;


import com.aviorent.models.Plane;
import com.aviorent.repositories.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaneServiceImpl implements PlaneService {
    @Autowired
    private PlaneRepository planeRepository;

    @Override
    public List<Plane> getAll() {
        return this.planeRepository.findAll();
    }
}
