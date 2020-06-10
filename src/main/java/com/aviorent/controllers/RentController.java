package com.aviorent.controllers;

import com.aviorent.models.CrewMember;
import com.aviorent.models.Rent;
import com.aviorent.services.CrewMemberTypeService;
import com.aviorent.services.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class RentController {

    @Autowired
    private RentService rentService;

    @GetMapping("/admin/rents")
    public String RentList(Model model)
    {
        List<Rent> rents = this.rentService.getAll();
        model.addAttribute("rents", rents);

        return "Rent/index";
    }

    @GetMapping("rents/create")
    public String CreateRentGet(Model model)
    {
        model.addAttribute("rent", new Rent());

        return "Rent/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String CreateRentPost(@Valid Rent rent, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            return "Rent/create";
        }
        else{
            Rent savedRent = rentService.create(rent);

            return "redirect:/index";
        }
    }

//    @PostMapping("/rents/delete")
//    public ModelAndView Delete(@RequestParam long rentId, RedirectAttributes redirectAttributes) {
//        rentService.deleteById(rentId);
//        redirectAttributes.addFlashAttribute("rentDeleted", true);
//        return new ModelAndView("redirect:/admin/rents");
//    }

    @RequestMapping("/rents/delete/{id}")
    public String Delete(@PathVariable Long id, RedirectAttributes redirectAttrs) {
        rentService.deleteById(id);
        redirectAttrs.addFlashAttribute("message", "Rent was deleted!");
        return "redirect:/admin/rents";
    }

    @RequestMapping("/rents/approve/{id}")
    public String Approve(@PathVariable Long id, RedirectAttributes redirectAttrs) {
        rentService.approveById(id);
        redirectAttrs.addFlashAttribute("message", "Rent was approved!");

        return "redirect:/admin/rents";
    }

}
