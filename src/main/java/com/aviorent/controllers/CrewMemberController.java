package com.aviorent.controllers;

import com.aviorent.models.CrewMember;
import com.aviorent.models.Plane;
import com.aviorent.services.CrewMemberService;
import com.aviorent.services.CrewMemberTypeService;
import com.aviorent.services.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CrewMemberController {

    @Autowired
    private CrewMemberService crewMemberService;

    @Autowired
    private CrewMemberTypeService crewMemberTypeService;

    @Autowired
    private PlaneService planeService;

    @GetMapping("/crewmemberlist")
    public String crewMembers(Model model){
        List<CrewMember> members = this.crewMemberService.getAll();
        model.addAttribute("members", members);
        model.addAttribute("crewMember", new CrewMember());
        model.addAttribute("type", crewMemberTypeService.getAll());
        model.addAttribute("plane", planeService.getAll());
        return "/CrewMember/list";
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCrewMember(@Valid CrewMember crewMember, RedirectAttributes redirectAttrs, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            model.addAttribute("type", crewMemberTypeService.getAll());
            model.addAttribute("plane", planeService.getAll());
            return "/CrewMember/createForm";
        }
        else{
            CrewMember savedCrewMember = crewMemberService.save(crewMember);
            redirectAttrs.addFlashAttribute("newCrewMember", true);
            return "redirect:/crewmemberlist";
        }
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttrs) {
        crewMemberService.deleteById(id);
        redirectAttrs.addFlashAttribute("crewMemberDeleted", true);
        return "redirect:/crewmemberlist";
    }


    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model, RedirectAttributes redirectAttrs) {
        model.addAttribute("cMember", crewMemberService.getById(id));
        model.addAttribute("cType", crewMemberTypeService.getAll());
        model.addAttribute("cPlane", planeService.getAll());
        redirectAttrs.addFlashAttribute("crewMemberUpdated", true);
        return "/CrewMember/createForm";
    }



}
