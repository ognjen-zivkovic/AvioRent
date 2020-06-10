package com.aviorent;


import com.aviorent.controllers.PlaneImageController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import java.io.File;

@SpringBootApplication
public class AviorentApplication {

    public static void main(String[] args) {
        new File(PlaneImageController.uploadDirectory).mkdirs();
        SpringApplication.run(AviorentApplication.class, args);

    }

    @Configuration
    public class AdditionalResourceWebConfiguration implements WebMvcConfigurer {

        @Override
        public void addResourceHandlers(final ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/upload/**").addResourceLocations("file:///" + System.getProperty("user.dir") + "/src/main/upload/");
        }
    }
}
