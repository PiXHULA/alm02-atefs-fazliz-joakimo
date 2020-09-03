package com.alm2atefsfazlizjoakimo.fortuneteller;

import com.alm2atefsfazlizjoakimo.fortuneteller.domain.Fortune;
import com.alm2atefsfazlizjoakimo.fortuneteller.domain.Person;
import com.alm2atefsfazlizjoakimo.fortuneteller.repository.FortuneRepository;
import com.alm2atefsfazlizjoakimo.fortuneteller.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class FortunetellerApplication implements CommandLineRunner {
    private final PersonRepository personRepository;
    private final FortuneRepository fortuneRepository;

    public static void main(String[] args) {
        SpringApplication.run(FortunetellerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (fortuneRepository.count() == 0) {
            /*personRepository.save(Person.builder()
                    .name("Joakim")
                    .Birthday("April 29")
                    .Ethnicity("Swedish Chilean")
                    .nationality("Sweden")
                    .Gender("Male")
                    .build());*/

            fortuneRepository.save(Fortune.builder()
                    .fortune("You will be rich some day")
                    .country("sweden")
                    .build());

            fortuneRepository.save(Fortune.builder()
                    .fortune("You will get broke today")
                    .country("denmark")
                    .build());

            fortuneRepository.save(Fortune.builder()
                    .fortune("No fortune for you ")
                    .country("usa")
                    .build());

            fortuneRepository.save(Fortune.builder()
                    .fortune("You will get shot ")
                    .country("japan")
                    .build());
        }

        // TODO Remove once testing is properly set up
        System.out.println(fortuneRepository.findDistinctByCountryIgnoreCase("SwEdEn"));
    }

}
