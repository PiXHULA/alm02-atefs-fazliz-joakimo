package com.alm2atefsfazlizjoakimo.fortuneteller.service;

import com.alm2atefsfazlizjoakimo.fortuneteller.domain.Fortune;
import com.alm2atefsfazlizjoakimo.fortuneteller.domain.Person;
import com.alm2atefsfazlizjoakimo.fortuneteller.repository.FortuneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FortuneService {

    private final FortuneRepository fortuneRepository;

    public Fortune getFortune(Person person){

       return fortuneRepository.findFortuneByCountryLike(person.getNationality().toLowerCase()).orElse(Fortune.builder()
                .fortune("YOU ARE GOING TO DIE SOON").build());

    }
}
