package com.aviorent.services;

import com.aviorent.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService{

    @Autowired

    private ClientRepository clientRepository;
}
