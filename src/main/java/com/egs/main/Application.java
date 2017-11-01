package com.egs.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.egs.config.ApplicationConfig;

public class Application {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ApplicationConfig.class);
        app.setWebEnvironment(false);
        app.run(args);
    }
}
