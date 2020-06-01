package com.aviorent.controllers;

import com.aviorent.models.CrewMember;
import com.aviorent.services.CrewMemberService;
import com.aviorent.services.CrewMemberTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CrewMemberController {

    @Autowired
    private CrewMemberService crewMemberService;

    @GetMapping("/crewMembers")
    public String crewMembers(Model model){
        List<CrewMember> members = this.crewMemberService.getAll();
        model.addAttribute("members", members);
        return "crewMembers";
    }
}
