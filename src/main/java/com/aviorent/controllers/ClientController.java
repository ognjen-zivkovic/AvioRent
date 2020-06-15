package com.aviorent.controllers;

import com.aviorent.config.MyClientDetails;
import com.aviorent.models.Client;
import com.aviorent.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/admin/clients")
    public String clients(Model model){
        List<Client> clients = this.clientService.getAll();
        model.addAttribute("clients", clients);
        return "listAllClients";
    }

    @GetMapping("/client")
    public String client(Model model, Principal principal) {
        String username = principal.getName();

        Client client = this.clientService.getByUsername(username).get();

        model.addAttribute("client", client);
        return "client";
    }

    @PostMapping(value = "/client")
    public ModelAndView updateClient(@ModelAttribute Client client, RedirectAttributes redirectAttributes) {
        ModelAndView model = new ModelAndView();
        clientService.update(client);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MyClientDetails clientDetails = (MyClientDetails) authentication.getPrincipal();
        clientDetails.setUserName(client.getUserName());

        model = new ModelAndView();
        model.addObject("msg", "User has been registered successfully");
        redirectAttributes.addFlashAttribute("ClientUpdated", true);
        model.setViewName("redirect:/allrents");
        return model;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView model = new ModelAndView();
        model.setViewName("/home");
        return model;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView signup(){
        ModelAndView model = new ModelAndView();
        Client client = new Client();
        model.addObject("client", client);
        model.setViewName("/signup");
        return model;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping("/default")
    public String defaultAfterLogin(HttpServletRequest request)
    {
        if(request.isUserInRole("ROLE_ADMIN"))
        {
            return "redirect:/admin/planes/page/1";
        }
        return "redirect:/home";
    }


    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ModelAndView createUser(@Valid Client client, BindingResult bindingResult){
        ModelAndView model = new ModelAndView();
        Client clientExists = clientService.findClientByEmail(client.getEmail());
        if(clientExists != null){
            bindingResult.rejectValue("email", "error.client", "This e-mail already exists!");
            model = new ModelAndView();
            model.addObject("Userexists", "User already exists");
            model.setViewName("/signup");
            Client client2 = new Client();
            client2.setPhone("");
            client2.setUserName("");

            model.addObject("client", client2);
            return model;
        }
        else if (bindingResult.hasErrors()){
            model.setViewName("/signup");
            return model;
        }
        else{
            client.setRoles("ROLE_USER");
            client.setPassword(passwordEncoder.encode(client.getPassword()));
            clientService.save(client);
            model.addObject("msg", "User has been registered successfully");
            model.addObject("client", new Client());
            model.setViewName("/customLogin");
        }

        return model;
    }

    @RequestMapping("/clients/delete/{id}")
    public String Delete(@PathVariable Long id, RedirectAttributes redirectAttrs) {
        clientService.deleteById(id);

        redirectAttrs.addFlashAttribute("message", "Client was deleted!");

        return "redirect:/admin/clients";
    }

}
