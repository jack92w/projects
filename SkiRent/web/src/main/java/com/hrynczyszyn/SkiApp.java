package com.hrynczyszyn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SkiApp extends SpringBootServletInitializer {

    public static void main(final String[] args) {
        SpringApplication.run(SkiApp.class, args);

    }
}
