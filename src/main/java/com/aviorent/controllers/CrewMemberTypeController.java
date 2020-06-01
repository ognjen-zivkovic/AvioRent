package com.aviorent.controllers;

import com.aviorent.models.CrewMemberType;
import com.aviorent.services.CrewMemberTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CrewMemberTypeController {

    @Autowired
    private CrewMemberTypeService crewMemberTypeService;

    @GetMapping("/crewMemberTypes")
    public String crewMemberTypes(Model model)
    {
        List<CrewMemberType> types = this.crewMemberTypeService.getAll();
        model.addAttribute("types", types);
        return "crewMemberTypes";
    }
}
