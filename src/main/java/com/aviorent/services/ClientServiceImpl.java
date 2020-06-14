package com.aviorent.services;

import com.aviorent.models.Client;
import com.aviorent.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService{

        @Autowired
        private ClientRepository clientRepository;


        @Override
        public List<Client> getAll(){
            return this.clientRepository.findAll();
        }

        @Override
        public Client save(Client client) {
            Client persistedClient = this.clientRepository.save(client);
            return persistedClient;
        }

        @Override
        public Optional<Client> getById(long id) {
            return this.clientRepository.findById(id);
        }

    @Override
    public Optional<Client> getByUsername(String username) {
        return this.clientRepository.findClientByUserName(username);
    }

    @Override
        public void deleteById(long id) {
            this.clientRepository.deleteById(id);
        }

        @Override
        public Client update(Client client) {

            Client persistedClient = this.clientRepository.save(client);
            return persistedClient;
        }

        @Override
        public Client findClientByEmail(String email) {
            return clientRepository.findByEmail(email);
        }



}
