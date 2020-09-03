package com.alm2atefsfazlizjoakimo.fortuneteller.controller;

import com.alm2atefsfazlizjoakimo.fortuneteller.domain.Person;
import com.alm2atefsfazlizjoakimo.fortuneteller.service.FortuneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/person") // TODO Change to "/fortune"?
@RequiredArgsConstructor
public class FortuneController {
    private final FortuneService fortuneService;

    @PostMapping
    public ResponseEntity<?> getFortune(@RequestBody @Valid Person person) {
        return ResponseEntity.ok(fortuneService.getFortune(person));
    }
}
