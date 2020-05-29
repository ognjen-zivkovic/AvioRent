package com.aviorent.controllers;

import com.aviorent.services.PilotServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.text.View;

@Controller
public class PilotsController {
    @RequestMapping(value = "/index")
    public String Index(Model model) {
        model.addAttribute("name", new String("Bojan"));
        return "index";
    }
}
