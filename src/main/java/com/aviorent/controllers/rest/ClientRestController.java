package com.aviorent.controllers.rest;

import com.aviorent.models.Client;
import com.aviorent.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;
import java.util.Optional;

@RestController
public class ClientRestController {

    @Autowired ClientService clientService;

    @GetMapping("/clientRest")
    public ResponseEntity<List<Client>> getClients()
    {
        return new ResponseEntity<>(this.clientService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/clientsRest")
    public ResponseEntity<Client> save(@RequestBody Client client)
    {
        return new ResponseEntity<>(clientService.save(client), HttpStatus.CREATED);
    }

    @GetMapping("/clientRest/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id)
    {
        Optional<Client> client = this.clientService.getById(id);
        return client.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(()->new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/clientRest/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id)
    {
        Optional<Client> client = this.clientService.getById(id);
        if(client.isPresent())
        {
            this.clientService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/clientRest/{id}")
    public ResponseEntity<Client> update(@RequestBody Client client, @PathVariable Long id)
    {
        Optional<Client> existingClient = this.clientService.getById(id);

        if(existingClient.isPresent()){
            Client newClient = existingClient.get();
            newClient.setClientId(client.getClientId());
            newClient.setUserName(client.getUserName());
            newClient.setEmail(client.getEmail());
            newClient.setPassword(client.getPassword());
            newClient.setPhone(client.getPhone());
            return new ResponseEntity<>(this.clientService.update(newClient), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
