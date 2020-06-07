package com.aviorent.controllers;

import com.aviorent.models.CrewMember;
import com.aviorent.models.CrewMemberType;
import com.aviorent.services.CrewMemberService;
import com.aviorent.services.CrewMemberTypeService;
import com.aviorent.services.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
        return "crewmemberlist";
    }

    @RequestMapping("/crewmemberadd")
    public String createCrewMember(Model model){

        model.addAttribute("crewMember", new CrewMember());
        model.addAttribute("type", crewMemberTypeService.getAll());
        model.addAttribute("plane", planeService.getAll());


        return "/crewmemberadd";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCrewMember(@Valid CrewMember crewMember, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            return "/crewmemberadd";
        }
        else{
            CrewMember savedCrewMember = crewMemberService.save(crewMember);
            return "redirect:/crewmemberlist";
        }
    }

   /* @RequestMapping("/admin/post/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttrs) {
        postService.delete(id);
        redirectAttrs.addFlashAttribute("message", "Post was deleted!");
        return "redirect:/admin/posts";
    }*/


}
