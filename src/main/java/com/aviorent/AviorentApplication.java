package com.aviorent;


import com.aviorent.config.WebConfig;
import com.aviorent.repositories.ClientRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.Ordered;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;


@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = ClientRepository.class)
public class AviorentApplication extends WebConfig {

    public static void main(String[] args) {
        SpringApplication.run(AviorentApplication.class, args);

    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("customLogin");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }
}
