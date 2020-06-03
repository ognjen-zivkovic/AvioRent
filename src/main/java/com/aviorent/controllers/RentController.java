package com.aviorent.controllers;

import com.aviorent.models.Rent;
import com.aviorent.services.CrewMemberTypeService;
import com.aviorent.services.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RentController {

    @Autowired
    private RentService rentService;

    @GetMapping("/rents")
    public String RentList(Model model)
    {
        List<Rent> rents = this.rentService.getAll();
        model.addAttribute("rents", rents);
        return "rentList";
    }
}
