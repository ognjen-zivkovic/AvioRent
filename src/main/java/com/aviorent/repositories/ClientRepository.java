package com.aviorent.repositories;


import com.aviorent.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository <Client, Long>
{
    Client findByEmail(String email);
    Optional<Client> findClientByUserName(String userName);
}
