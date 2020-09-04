package com.alm2atefsfazlizjoakimo.fortuneteller.bootstrap;

import com.alm2atefsfazlizjoakimo.fortuneteller.domain.Fortune;
import com.alm2atefsfazlizjoakimo.fortuneteller.repository.FortuneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PopulateDatabase implements CommandLineRunner {

    private final FortuneRepository fortuneRepository;

    @Override
    public void run(String... args) {
        if (fortuneRepository.count() == 0) {

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
