package com.aviorent.services;

import com.aviorent.models.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    List<Client> getAll();
    Client save(Client client);
    Optional<Client> getById(long id);
    void deleteById(long id);
    Client update(Client client);
}
