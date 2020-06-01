package com.aviorent.controllers;

import com.aviorent.models.Plane;
import com.aviorent.services.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PlaneController {

    @Autowired
    private PlaneService planeService;
    @GetMapping("/planes")
    public String planes(Model model)
    {
        List<Plane> planes = planeService.getAll();
        model.addAttribute("planes",planes);
        return "planes";
    }
}
