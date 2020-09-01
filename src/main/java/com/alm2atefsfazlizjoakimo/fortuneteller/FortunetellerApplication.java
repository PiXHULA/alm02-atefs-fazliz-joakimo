package com.alm2atefsfazlizjoakimo.fortuneteller;

import com.alm2atefsfazlizjoakimo.fortuneteller.domain.Person;
import com.alm2atefsfazlizjoakimo.fortuneteller.repository.MongoDb;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class FortunetellerApplication implements CommandLineRunner {

    private final MongoDb mongoDb;
    public static void main(String[] args) {
        SpringApplication.run(FortunetellerApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        mongoDb.save(Person.builder().name("Joakim").build());
    }
}
