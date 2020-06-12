package com.aviorent.controllers;

import com.aviorent.models.Client;
import com.aviorent.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.validation.Valid;
import java.util.List;

@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/clients")
    public String clients(Model model){
        List<Client> clients = this.clientService.getAll();
        model.addAttribute("clients", clients);
        return "clients";
    }

    @GetMapping("/client")
    public String client(Model model) {
        Client client = this.clientService.getById(503).get();
        model.addAttribute("client", client);
        return "client";
    }


    @RequestMapping(value = "/client", method = RequestMethod.POST)
    public String updateClient(@ModelAttribute Client client) {
        clientService.update(client);
        return "client";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
        public ModelAndView index() {
        ModelAndView model = new ModelAndView();

        model.setViewName("/index");

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
            model.setViewName("/signup");
        }

        return model;
    }

}
