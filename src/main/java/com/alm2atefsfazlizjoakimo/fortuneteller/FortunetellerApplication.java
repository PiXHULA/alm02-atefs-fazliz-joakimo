package com.alm2atefsfazlizjoakimo.fortuneteller;

import com.alm2atefsfazlizjoakimo.fortuneteller.domain.Fortune;
import com.alm2atefsfazlizjoakimo.fortuneteller.repository.FortuneRepository;
import com.alm2atefsfazlizjoakimo.fortuneteller.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FortunetellerApplication{

    public static void main(String[] args) {
        SpringApplication.run(FortunetellerApplication.class, args);
    }
}
