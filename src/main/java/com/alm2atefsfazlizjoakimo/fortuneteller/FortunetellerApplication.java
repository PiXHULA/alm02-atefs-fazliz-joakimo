package com.alm2atefsfazlizjoakimo.fortuneteller;

import com.alm2atefsfazlizjoakimo.fortuneteller.domain.Person;
import com.alm2atefsfazlizjoakimo.fortuneteller.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class FortunetellerApplication implements CommandLineRunner {

    private final PersonRepository personRepository;
    public static void main(String[] args) {
        SpringApplication.run(FortunetellerApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        personRepository.save(Person.builder()
                .name("Joakim")
                .Birthday("April 29")
                .Ethnicity("Swedish Chilean")
                .nationality("Sweden")
                .Gender("Male")
                .build());
    }
}
