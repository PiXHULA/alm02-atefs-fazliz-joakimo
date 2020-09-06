package com.alm2atefsfazlizjoakimo.fortuneteller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class FortunetellerApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(FortunetellerApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(FortunetellerApplication.class);
    }
}
