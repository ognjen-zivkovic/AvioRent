package com.aviorent;


import com.aviorent.config.WebConfig;
import com.aviorent.controllers.PlaneImageController;
import com.aviorent.repositories.ClientRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;


@SpringBootApplication
@EnableCaching
@EnableJpaRepositories(basePackageClasses = ClientRepository.class)
public class AviorentApplication extends WebConfig {


    public static void main(String[] args) {
        new File(PlaneImageController.uploadDirectory).mkdirs();
        SpringApplication.run(AviorentApplication.class, args);

    }


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("customLogin");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

    @Configuration
    public class AdditionalResourceWebConfiguration implements WebMvcConfigurer {

        @Override
        public void addResourceHandlers(final ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/upload/**").addResourceLocations("file:///" + System.getProperty("user.dir") + "/src/main/upload/");
        }

    }
}
