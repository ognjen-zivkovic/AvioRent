package com.aviorent.controllers;

import com.aviorent.models.Client;
import com.aviorent.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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


}
