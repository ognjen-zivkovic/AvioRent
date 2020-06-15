package com.aviorent.controllers;

import com.aviorent.dtos.PlaneWithImagesDto;
import com.aviorent.dtos.RentDto;
import com.aviorent.models.Client;
import com.aviorent.models.CrewMember;
import com.aviorent.models.Plane;
import com.aviorent.models.Rent;
import com.aviorent.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.standard.expression.GreaterOrEqualToExpression;

import javax.validation.Valid;
import java.security.Principal;
import java.text.ParseException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class RentController {

    @Autowired
    private RentService rentService;

    @Autowired
    private PlaneService planeService;

    @Autowired
    private PlaneImageService planeImageService;

    @Autowired
    private ClientService clientService;

//    @GetMapping("/admin/rents/page/{page}")
//    public ModelAndView RentList(@PathVariable("page") int page)
//    {
//        ModelAndView modelAndView = new ModelAndView("Rent/index");
//        PageRequest pageable = PageRequest.of(page - 1, 5, Sort.by("dateStart").descending());
//        Page<Rent> rentPage = rentService.getPaginatedRents(pageable);
//        int totalPages = rentPage.getTotalPages();
//
//        if(totalPages > 0 ) {
//            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
//            modelAndView.addObject("pageNumbers", pageNumbers);
//        }
//
//        modelAndView.addObject("activeRentList", true);
//        modelAndView.addObject("rents", rentPage.getContent());
//
//        return modelAndView;
//    }

    @GetMapping("/admin/rents")
    public String RentList(Model model)
    {
        List<Rent> rents = this.rentService.getAll();
        model.addAttribute("rents", rents);

        return "Rent/index";
    }

    // Dusan - all rents for user
    @GetMapping("/allrents")
    public String AllRents(Model model, Principal principal)
    {
        String name = principal.getName();

        List<Rent> rents = this.rentService.getAllByUserName(name);
        model.addAttribute("rents", rents);

        return "/listAllReservations";
    }

    @GetMapping(value ={"/home","","/"})
    public String Home(Model model)
    {
        model.addAttribute("rent", new RentDto());

        return "home";
    }

    @RequestMapping(value = "/rents/next", method = RequestMethod.POST)
    public ModelAndView SubmitRentInfo(@Valid RentDto rent, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes, Principal principal) {
        if(bindingResult.hasErrors()){
            return new ModelAndView("home");
        }
        else {
            if (principal == null)
            {
                redirectAttributes.addFlashAttribute("LoginRequired", true);
                return new ModelAndView("redirect:/login");
            }

            Optional<Client> client = clientService.getByUsername(principal.getName());
            if(client.get().getRoles().contains("ROLE_ADMIN"))
            {
                redirectAttributes.addFlashAttribute("isAdmin", true);
                return new ModelAndView("redirect:/home");
            }

            redirectAttributes.addFlashAttribute("rent", rent);

            return new ModelAndView("redirect:/rents/choosePlane");
        }
    }

    @RequestMapping(value = "/rents/choosePlane", method = RequestMethod.GET)
    public String ChoosePlane(Model model) {
        RentDto rentDto = (RentDto) model.asMap().get("rent");
        if(rentDto == null)
        {
            return "redirect:/home";
        }

        List<Plane> planes = this.planeService.getAll();
        List<PlaneWithImagesDto> dto = new ArrayList<PlaneWithImagesDto>();

        for (Plane p : planes) {
            PlaneWithImagesDto temp = new PlaneWithImagesDto();

            temp.setPlaneId(p.getPlaneId());
            temp.setMaxSpeed(p.getMaxSpeed());
            temp.setModel(p.getModel());
            temp.setPrice(p.getPrice());
            temp.setRange(p.getRange());
            temp.setSeats(p.getSeats());
            temp.setImages(planeImageService.getAllByPlane(p));
            dto.add(temp);
        }

        model.addAttribute("planes", dto);
        model.addAttribute("rent", rentDto);

        return "Rent/choosePlane";
    }

    @RequestMapping(value = "/rents/submit", method = RequestMethod.POST)
    public ModelAndView CreateRent(@Valid RentDto rentDto, BindingResult bindingResult, Model model, Principal principal, RedirectAttributes redirectAttributes) throws ParseException {
        if(bindingResult.hasErrors()){
            return new ModelAndView("Rent/choosePlane");
        }
        else{
            Rent rent = new Rent();
            rentDto.setClient(new Client());
            rentDto.getClient().setUserName(principal.getName());

            rent.setPassengers(rentDto.getPassengers());
            rent.setDestinationFrom(rentDto.getDestinationFrom());
            rent.setDestinationTo(rentDto.getDestinationTo());
            rent.setDateStart(rentDto.getDateStart());
            rent.setRoundTrip(rentDto.isRoundTrip());
            rent.setPlane(rentDto.getPlane());
            rent.setClient(rentDto.getClient());

            Rent savedRent = rentService.create(rent);

            redirectAttributes.addFlashAttribute("RentCreated", true);

            return new ModelAndView("redirect:/allrents");
        }
    }


    @RequestMapping("/rents/delete/{id}")
    public String Delete(@PathVariable Long id, RedirectAttributes redirectAttrs) {
        rentService.deleteById(id);

        redirectAttrs.addFlashAttribute("rentDeleted", true);

        return "redirect:/admin/rents";
    }

    @RequestMapping("/rents/approve/{id}")
    public String Approve(@PathVariable Long id, RedirectAttributes redirectAttrs) {
        rentService.approveById(id);
        redirectAttrs.addFlashAttribute("rentApproved", true);

        return "redirect:/admin/rents";
    }

}
