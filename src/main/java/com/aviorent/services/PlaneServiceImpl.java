package com.aviorent.services;


import com.aviorent.repositories.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PlaneServiceImpl implements PlaneService {
    @Autowired
    private PlaneRepository planeRepository;
}
