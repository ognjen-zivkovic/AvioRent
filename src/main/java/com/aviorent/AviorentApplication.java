package com.aviorent;


import com.aviorent.repositories.ClientRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = ClientRepository.class)
public class AviorentApplication {

    public static void main(String[] args) {
        SpringApplication.run(AviorentApplication.class, args);

    }
}
