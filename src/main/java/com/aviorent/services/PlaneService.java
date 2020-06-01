package com.aviorent.services;

import com.aviorent.models.Plane;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PlaneService {
    List<Plane> getAll();
}
