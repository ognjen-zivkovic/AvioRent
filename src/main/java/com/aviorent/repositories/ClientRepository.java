package com.aviorent.repositories;


import com.aviorent.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository <Client, Long>
{

}
