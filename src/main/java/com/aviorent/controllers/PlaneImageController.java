package com.aviorent.controllers;


import com.aviorent.services.PlaneImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PlaneImageController {
    public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/upload/static/planeImages";

    @Autowired
    private PlaneImageService planeImageService;




}
