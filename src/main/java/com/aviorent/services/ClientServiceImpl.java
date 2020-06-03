package com.aviorent.services;

import com.aviorent.models.Client;
import com.aviorent.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService{

    @Autowired

    private ClientRepository clientRepository;

    @Override
    public List<Client> getAll(){
        return this.clientRepository.findAll();
    }

}
