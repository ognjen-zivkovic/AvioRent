package com.aviorent.controllers;

import com.aviorent.models.RentStatus;
import com.aviorent.services.RentStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class RentStatusController {

    @Autowired
    private RentStatusService rentStatusService;

    @GetMapping("/rentstatus")
    public String rentStatus(Model model)
    {
        List<RentStatus> rentstatus = this.rentStatusService.getAll();
        model.addAttribute("rentstatus", rentstatus);
        return "rentStatus";
    }

}
