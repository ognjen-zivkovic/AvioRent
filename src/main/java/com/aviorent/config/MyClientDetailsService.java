package com.aviorent.config;

import com.aviorent.models.Client;
import com.aviorent.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyClientDetailsService implements UserDetailsService {

    @Autowired
    ClientRepository clientRepository;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
       Optional<Client> client =  clientRepository.findClientByUserName(userName);

       client.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));

       return client.map(MyClientDetails::new).get();
    }
}
